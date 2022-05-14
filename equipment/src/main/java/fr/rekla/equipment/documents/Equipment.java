package fr.rekla.equipment.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "equipment")
public class Equipment {
    @Id
    private Integer id;

    @Indexed(unique = true)
    @Field(value = "equipment_No")
    private String equipmentNo;

    @Field(value = "description")
    private String description;
}
