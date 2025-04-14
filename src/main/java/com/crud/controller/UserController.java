package com.crud.controller;

import com.crud.model.UserModel;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        UserModel createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<UserModel> getUserByAccountNumber(@PathVariable String accountNumber) {
        return userService.getUserByAccountNumber(accountNumber)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search/lastname")
    public ResponseEntity<List<UserModel>> getUsersByLastName(@RequestParam String lastName) {
        List<UserModel> users = userService.getUsersByLastName(lastName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/search/firstname")
    public ResponseEntity<List<UserModel>> getUsersByFirstName(@RequestParam String firstName) {
        List<UserModel> users = userService.getUsersByFirstName(firstName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<UserModel> updateUser(@PathVariable String accountNumber, @RequestBody UserModel user) {
        return userService.updateUser(accountNumber, user)
                .map(updatedUser -> new ResponseEntity<>(updatedUser, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
