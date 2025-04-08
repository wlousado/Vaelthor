package br.rpg.vaelthor.contract.dice.response;

import lombok.Builder;

@Builder
public record DiceInfoResponse(
        Integer highest,
        Integer lowest,
        Integer sum
) {
}
