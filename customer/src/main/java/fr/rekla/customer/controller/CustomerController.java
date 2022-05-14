package fr.rekla.customer.controller;

import fr.rekla.customer.entities.Customer;
import fr.rekla.customer.entities.Equipment;
import fr.rekla.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Customer> storeCustomer(@RequestBody Customer customer) {
        log.info("Customer name : {}", customer.getLastName());
        return new ResponseEntity<>(customerService.storeCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}/equipment")
    public ResponseEntity<Equipment> getEquipment(@PathVariable("customerId") Integer customerId) {
        Equipment equipment = restTemplate.getForObject(
                "http://localhost:8082/api/v1/equipments/{customerid}",
                Equipment.class,
                customerId
        );
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }
}
