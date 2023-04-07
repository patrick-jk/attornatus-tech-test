package com.attornatus.techtest.repository;

import com.attornatus.techtest.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<List<Address>> findByPersonId(Long personId);
}