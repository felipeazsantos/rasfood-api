package dev.felipeazsantos.api.rasfood.service.impl;

import dev.felipeazsantos.api.rasfood.entity.Address;
import dev.felipeazsantos.api.rasfood.exception.NotFoundException;
import dev.felipeazsantos.api.rasfood.repository.AddressRepository;
import dev.felipeazsantos.api.rasfood.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("address not found"));
    }

    @Override
    public List<Address> findByCep(String cep) {
        return addressRepository.findByCep(cep);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
