package com.rentit.demo.controller;

import com.rentit.demo.model.User;
import com.rentit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return repository.findAll();
    }

}
