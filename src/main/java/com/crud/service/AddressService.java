package com.crud.service;

import com.crud.model.Address;
import com.crud.model.UserModel;
import com.crud.repository.AddressRepository;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public List<Address> getAddressesByAccountNumber(String accountNumber) {
        return addressRepository.findByUserAccountNumber(accountNumber);
    }

    public Optional<Address> createAddress(String accountNumber, Address address) {
        return userRepository.findById(accountNumber)
                .map(user -> {
                    address.setUser(user);
                    return addressRepository.save(address);
                });
    }

    public Optional<Address> updateAddress(Long id, Address updatedAddress) {
        return addressRepository.findById(id)
                .map(existingAddress -> {
                    existingAddress.setStreetNumber(updatedAddress.getStreetNumber());
                    existingAddress.setCity(updatedAddress.getCity());
                    existingAddress.setState(updatedAddress.getState());
                    existingAddress.setZipcode(updatedAddress.getZipcode());
                    return addressRepository.save(existingAddress);
                });
    }

}