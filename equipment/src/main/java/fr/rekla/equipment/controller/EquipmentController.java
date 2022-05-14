package fr.rekla.equipment.controller;

import fr.rekla.equipment.documents.Equipment;
import fr.rekla.equipment.service.EquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> storeEquipment(@RequestBody Equipment equipment) {
        return new ResponseEntity<>(equipmentService.storeEquipment(equipment), HttpStatus.CREATED);
    }

    @GetMapping("/{equipmentId}")
    public Equipment retrieveEquipmentById(@PathVariable("equipmentId") Integer equipmentId) {
        return equipmentService.retrieveEquipmentById(equipmentId);
    }
}
