package br.rpg.vaelthor.contract.world.general.response;

public record WorldGeneralContractResponse(
        String id,
        String name,
        String settings,
        CurrentStateWorldGeneralResponse currentState
) {
}
