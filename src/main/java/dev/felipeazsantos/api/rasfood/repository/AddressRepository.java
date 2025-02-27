package dev.felipeazsantos.api.rasfood.repository;

import dev.felipeazsantos.api.rasfood.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCep(String cep);
}
