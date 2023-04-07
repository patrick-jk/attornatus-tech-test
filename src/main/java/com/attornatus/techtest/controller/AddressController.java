package com.attornatus.techtest.controller;

import com.attornatus.techtest.domain.Address;
import com.attornatus.techtest.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping(path = "/{personId}")
    public ResponseEntity<List<Address>> findAddressesByPersonId(@PathVariable long personId) {
        return ResponseEntity.ok(addressService.findAddressesByPersonIdOrThrowBadRequestException(personId));
    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody @Valid Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
