package br.rpg.vaelthor.impl.model.world.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorldGeneral {
    @Id
    private String id;
    private String name;
    private String settings;
    private CurrentStateWorldGeneral currentState;
}
