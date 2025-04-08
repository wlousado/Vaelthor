package br.rpg.vaelthor.impl.service.world.general;

import br.rpg.vaelthor.contract.world.general.request.WorldGeneralRequest;
import br.rpg.vaelthor.contract.world.general.response.WorldGeneralContractResponse;
import br.rpg.vaelthor.impl.model.world.general.WorldGeneral;
import br.rpg.vaelthor.impl.repository.world.general.WorldGeneralRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorldGeneralService {

    private final WorldGeneralRepository repository;


    public Mono<WorldGeneral> createWorldGeneral(WorldGeneral request) {
        return repository.save(request);
    }
}
