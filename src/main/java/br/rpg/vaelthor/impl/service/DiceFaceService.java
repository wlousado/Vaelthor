package br.rpg.vaelthor.impl.service;

import br.rpg.vaelthor.common.enums.DiceFace;
import br.rpg.vaelthor.common.exception.DiceFaceException;
import br.rpg.vaelthor.contract.dice.response.DiceInfoResponse;
import br.rpg.vaelthor.contract.dice.response.WrapDiceRollResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class DiceFaceService {

    private static final String PATTERN_DICE = "^(\\d+)(d\\d+)([+-]\\d+)?$";
    private static final String FAILED_TO_GENERATE_RANDOM = "Failed to generate number by SecureRandom.getInstanceStrong()";
    private static final String FAILED_TO_GET_PATTERN_DICE = "Value of dice not valid. pattern: quanty + dice. try: 4d6, 12d20";
    private static final int FALLBACK_VALUE = 999;

    public Mono<WrapDiceRollResponse> doRollDice(String dicePathParam) {
        return Mono.just(dicePathParam)
                .doOnNext(param -> log.info("[DiceFaceService] doRollDice - Received dice roll request: {}", param))
                .flatMap(diceParam -> {
                    Pattern pattern = Pattern.compile(PATTERN_DICE);
                    Matcher matcher = pattern.matcher(diceParam);
                    if (!matcher.matches()) {
                        log.warn("[DiceFaceService] doRollDice - Invalid dice format: {}", diceParam);
                        return Mono.error(new DiceFaceException(FAILED_TO_GET_PATTERN_DICE));
                    }

                    var quantity = Integer.parseInt(matcher.group(1));
                    var dice = DiceFace.valueOf(matcher.group(2).toUpperCase(Locale.ROOT));
                    var modifier = matcher.group(3);

                    return Flux.range(0, quantity)
                            .flatMap(i -> randomGeneratorReactive(dice.getFace()))
                            .collectList()
                            .flatMap(result -> {
                                int max = result.stream().max(Integer::compare).orElseThrow();
                                int min = result.stream().min(Integer::compare).orElseThrow();
                                int sum = result.stream().mapToInt(Integer::intValue).sum();

                                return Mono.just(new WrapDiceRollResponse(dicePathParam, dice, getModifier(modifier, sum), modifier, result, DiceInfoResponse.builder()
                                        .highest(max)
                                        .lowest(min)
                                        .sum(sum)
                                        .build()));
                            });
                }).onErrorResume(e -> {
            log.error("[DiceFaceService] doRollDice - Error processing dice roll: {}", e.getMessage(), e);
            return Mono.error(new DiceFaceException("Unexpected error rolling dice."));
        });

    }

    private Integer getModifier(String modifier, Integer sumResultDice) {
        if (modifier == null || modifier.isEmpty()) {
            return sumResultDice;
        }
        char operator = modifier.charAt(0);
        int value = Integer.parseInt(modifier.substring(1));

        return switch (operator){
            case '+' -> sumResultDice + value;
            case '-' -> sumResultDice - value;
            default -> sumResultDice;
        };
    }

    private Mono<Integer> randomGeneratorReactive(int face) {
        return Mono.fromCallable(() -> {
            try {
                return SecureRandom.getInstanceStrong().nextInt(face) + 1;
            } catch (NoSuchAlgorithmException e) {
                log.error("[DiceFaceService] doRollDice - " + FAILED_TO_GENERATE_RANDOM, e);
                return FALLBACK_VALUE;
            }
        }).onErrorReturn(FALLBACK_VALUE);
    }
}
