package br.rpg.vaelthor.contract.world.general.request;

import java.util.List;

public record CurrentStateWorldGeneralRequest(
        String id,
        String status,
        List<String> features
) {
}
