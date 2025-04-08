package br.rpg.vaelthor.contract.dice.request;

import br.rpg.vaelthor.common.enums.DiceFace;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record DiceRollRequest(
        DiceFace diceFace,
        @Min(1) @Max(10)
        Integer quantityOfDice
) {
}
