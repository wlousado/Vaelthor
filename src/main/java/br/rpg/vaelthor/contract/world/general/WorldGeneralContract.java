package br.rpg.vaelthor.contract.world.general;

import br.rpg.vaelthor.contract.world.general.request.WorldGeneralRequest;
import br.rpg.vaelthor.contract.world.general.response.WorldGeneralContractResponse;
import br.rpg.vaelthor.impl.model.world.general.WorldGeneral;
import br.rpg.vaelthor.impl.service.world.general.WorldGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/world/general")
@RequiredArgsConstructor
public class WorldGeneralContract {

    private final WorldGeneralService service;

    @PostMapping
    public Mono<WorldGeneral> createWorldGeneral(WorldGeneralRequest request){
        //return service.createWorldGeneral(request);
        return Mono.empty();
    }
}
