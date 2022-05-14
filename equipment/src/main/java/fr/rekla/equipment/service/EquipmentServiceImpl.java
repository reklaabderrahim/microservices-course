package fr.rekla.equipment.service;

import fr.rekla.equipment.documents.Equipment;
import fr.rekla.equipment.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment storeEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment retrieveEquipmentById(Integer id) {
        return equipmentRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
