package com.rentit.demo.controller;

import com.rentit.demo.model.User;
import com.rentit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return repository.findAll();
    }

}
