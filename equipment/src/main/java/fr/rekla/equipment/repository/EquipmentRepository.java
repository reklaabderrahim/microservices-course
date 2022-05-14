package fr.rekla.equipment.repository;

import fr.rekla.equipment.documents.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepository extends MongoRepository<Equipment, Integer> {
}
