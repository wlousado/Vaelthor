package br.rpg.vaelthor.contract.world.general.request;

public record WorldGeneralRequest(
        String name,
        String settings,
        CurrentStateWorldGeneralRequest currentState
) {
}
