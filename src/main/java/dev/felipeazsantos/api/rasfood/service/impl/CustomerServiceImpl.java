package dev.felipeazsantos.api.rasfood.service.impl;

import dev.felipeazsantos.api.rasfood.entity.Customer;
import dev.felipeazsantos.api.rasfood.exception.NotFoundException;
import dev.felipeazsantos.api.rasfood.repository.CustomerRepository;
import dev.felipeazsantos.api.rasfood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("customer not found"));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("customer not found"));
    }


    @Override
    public Customer findByCpf(String cpf) {
        return customerRepository.findByCpf(cpf).orElseThrow(() -> new NotFoundException("customer not found"));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
