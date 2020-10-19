package com.rentit.demo.controller;

import com.rentit.demo.model.User;
import com.rentit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping(path = "/users")
    public User updateUser(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/users/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return MessageFormat.format("User with ID {0} has been deleted.", id);
    }
}
