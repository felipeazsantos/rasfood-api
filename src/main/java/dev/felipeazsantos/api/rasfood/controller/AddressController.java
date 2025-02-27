package dev.felipeazsantos.api.rasfood.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.felipeazsantos.api.rasfood.entity.Address;
import dev.felipeazsantos.api.rasfood.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("cep/{cep}")
    public ResponseEntity<List<Address>> findByCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(addressService.findByCep(cep));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable("id") Long id, @RequestBody Address address) throws JsonMappingException {
        Address addressFounded = addressService.findById(id);
        objectMapper.updateValue(addressFounded, address);
        return ResponseEntity.ok(addressFounded);
    }


}
