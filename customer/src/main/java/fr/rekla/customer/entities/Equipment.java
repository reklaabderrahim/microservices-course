package fr.rekla.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private Integer id;
    private String equipmentNo;
    private String description;
}
