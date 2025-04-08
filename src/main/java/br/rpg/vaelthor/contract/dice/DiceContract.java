package br.rpg.vaelthor.contract.dice;

import br.rpg.vaelthor.contract.dice.response.WrapDiceRollResponse;
import br.rpg.vaelthor.impl.service.DiceFaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/dice")
@Slf4j
public class DiceContract {

    private final DiceFaceService diceFaceService;

    @GetMapping("/roll/{dice}")
    public Mono<WrapDiceRollResponse> doRoll(@PathVariable String dice) {
        return diceFaceService.doRollDice(dice);
    }
}
