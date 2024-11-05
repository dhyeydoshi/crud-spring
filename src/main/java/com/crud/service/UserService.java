package com.crud.service;


import com.crud.model.UserModel;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }


    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    public Optional<UserModel> getUserById(int id) {
        return userRepository.findById(id);
    }


    public UserModel updateUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}

