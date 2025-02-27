package dev.felipeazsantos.api.rasfood.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.felipeazsantos.api.rasfood.entity.Customer;
import dev.felipeazsantos.api.rasfood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PatchMapping("/{email}")
    public ResponseEntity<Customer> updateByEmail(@PathVariable("email") String email, @RequestBody Customer customer) throws JsonMappingException {
        Customer customerFounded = customerService.findByEmail(email);
        objectMapper.updateValue(customerFounded, customer);
        return ResponseEntity.ok(customerService.save(customerFounded));
    }
}
