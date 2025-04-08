package br.rpg.vaelthor.contract.world.general.response;

import java.util.List;

public record CurrentStateWorldGeneralResponse(
        String id,
        String status,
        List<String> features
) {
}
