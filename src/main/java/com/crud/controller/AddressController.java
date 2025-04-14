package com.crud.controller;

import com.crud.model.Address;
import com.crud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id)
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{accountNumber}")
    public ResponseEntity<List<Address>> getAddressesByAccountNumber(@PathVariable String accountNumber) {
        List<Address> addresses = addressService.getAddressesByAccountNumber(accountNumber);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PostMapping("/user/{accountNumber}")
    public ResponseEntity<Address> createAddress(@PathVariable String accountNumber, @RequestBody Address address) {
        return addressService.createAddress(accountNumber, address)
                .map(createdAddress -> new ResponseEntity<>(createdAddress, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        return addressService.updateAddress(id, address)
                .map(updatedAddress -> new ResponseEntity<>(updatedAddress, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
