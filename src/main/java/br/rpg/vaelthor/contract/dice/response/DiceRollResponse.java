package br.rpg.vaelthor.contract.dice.response;

import lombok.Builder;

@Builder
public record DiceRollResponse (
        Integer result
){

}
