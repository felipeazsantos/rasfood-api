package dev.felipeazsantos.api.rasfood.service;

import java.util.List;
import dev.felipeazsantos.api.rasfood.entity.Address;
import java.util.Optional;

public interface AddressService {

    List<Address> findAll();
    Address findById(Long id);
    List<Address> findByCep(String cep);
    Address save(Address address);
}
