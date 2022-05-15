package fr.rekla.customer.controller;

import fr.rekla.customer.entities.Customer;
import fr.rekla.customer.entities.Equipment;
import fr.rekla.customer.feign.EquipmentClientService;
import fr.rekla.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final EquipmentClientService equipmentClientService;

    @PostMapping
    public ResponseEntity<Customer> storeCustomer(@RequestBody Customer customer) {
        log.info("CUSTOMER:: create customer");
        return new ResponseEntity<>(customerService.storeCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}/equipment")
    public ResponseEntity<Equipment> getEquipment(@PathVariable("customerId") Integer customerId) {
        log.info("CUSTOMER:: fetch customer equipment");
        return equipmentClientService.retrieveEquipmentById(customerId);
    }
}
