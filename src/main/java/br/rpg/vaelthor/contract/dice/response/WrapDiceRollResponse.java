package br.rpg.vaelthor.contract.dice.response;

import br.rpg.vaelthor.common.enums.DiceFace;

import java.util.List;

public record WrapDiceRollResponse(
        String dice,
        DiceFace diceFace,
        Integer diceWithModifier,
        String modifier,
        List<Integer> result,
        DiceInfoResponse info
) {
}
