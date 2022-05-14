package fr.rekla.equipment.service;

import fr.rekla.equipment.documents.Equipment;

public interface EquipmentService {
    Equipment storeEquipment(Equipment equipment);
    Equipment retrieveEquipmentById(Integer id);
}
