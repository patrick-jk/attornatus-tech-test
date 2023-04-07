package com.attornatus.techtest.service;

import com.attornatus.techtest.domain.Address;
import com.attornatus.techtest.exception.BadRequestException;
import com.attornatus.techtest.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> findAddressesByPersonIdOrThrowBadRequestException(long personId) {
        return addressRepository.findByPersonId(personId)
                .orElseThrow(() -> new BadRequestException("No address found for personId"));
    }

    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
