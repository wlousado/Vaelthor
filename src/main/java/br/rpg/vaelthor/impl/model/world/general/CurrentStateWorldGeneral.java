package br.rpg.vaelthor.impl.model.world.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrentStateWorldGeneral {
    @Id
    private String id;
    private String status;
    private List<String> features;
}
