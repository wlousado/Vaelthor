package br.rpg.vaelthor.impl.repository.world.general;

import br.rpg.vaelthor.impl.model.world.general.WorldGeneral;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldGeneralRepository extends ReactiveMongoRepository<WorldGeneral, String> {
}
