package fr.rekla.customer.service;

import fr.rekla.customer.entities.Customer;
import fr.rekla.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public Customer storeCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }
}
