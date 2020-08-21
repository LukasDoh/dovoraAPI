package com.dovora.dovoraAPI.controller;

import com.dovora.dovoraAPI.exception.ArticleNotFoundException;
import com.dovora.dovoraAPI.exception.CustomerNotFoundException;
import com.dovora.dovoraAPI.model.Article;
import com.dovora.dovoraAPI.model.Customer;
import com.dovora.dovoraAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow CORS
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // Get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Create a new Customer
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Get a single Customer
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable(value= "id") Long customerId) throws CustomerNotFoundException {

        return customerRepository.findById(customerId).
                orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    // Update a Customer
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") Long customerId,
                              @Valid @RequestBody Customer customerDetails) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setStreet(customerDetails.getStreet());
        customer.setZipCode(customerDetails.getZipCode());
        customer.setCity(customerDetails.getCity());
        customer.setCountry(customerDetails.getCountry());

        Customer updatedCustomer = customerRepository.save(customer);

        return updatedCustomer;
    }

    // Delete a Customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        customerRepository.delete(customer);

        return ResponseEntity.ok().build();
    }
}
