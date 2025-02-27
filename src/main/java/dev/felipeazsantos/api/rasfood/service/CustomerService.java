package dev.felipeazsantos.api.rasfood.service;

import dev.felipeazsantos.api.rasfood.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer findByEmail(String email);

    Customer findByCpf(String cpf);

    Customer save(Customer customer);
}
