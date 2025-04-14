package com.crud.service;

import com.crud.model.UserModel;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserByAccountNumber(String accountNumber) {
        return userRepository.findById(accountNumber);
    }

    public List<UserModel> getUsersByLastName(String lastName) {
        return userRepository.findByLastNameContaining(lastName);
    }

    public List<UserModel> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstNameContaining(firstName);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> updateUser(String accountNumber, UserModel updatedUser) {
        return userRepository.findById(accountNumber)
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
                    existingUser.setEmail(updatedUser.getEmail());
                    return userRepository.save(existingUser);
                });
    }

}

