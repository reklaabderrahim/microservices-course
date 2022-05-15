package fr.rekla.equipment.controller;

import fr.rekla.equipment.documents.Equipment;
import fr.rekla.equipment.service.EquipmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> storeEquipment(@RequestBody Equipment equipment) {
        log.info("EQUIPMENT:: create equipment");
        return new ResponseEntity<>(equipmentService.storeEquipment(equipment), HttpStatus.CREATED);
    }

    @GetMapping("/{equipmentId}")
    public Equipment retrieveEquipmentById(@PathVariable("equipmentId") Integer equipmentId) {
        log.info("EQUIPMENT:: Fetch equipment");
        return equipmentService.retrieveEquipmentById(equipmentId);
    }
}
