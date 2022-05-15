package fr.rekla.customer.feign;

import fr.rekla.customer.entities.Equipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EQUIPMENT", path = "/api/v1/equipments")
public interface EquipmentClientService {

    @GetMapping("/{equipmentId}")
    ResponseEntity<Equipment> retrieveEquipmentById(@PathVariable("equipmentId") Integer equipmentId);
}
