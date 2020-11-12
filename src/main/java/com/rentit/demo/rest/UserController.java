package com.rentit.demo.rest;

import com.rentit.demo.model.User;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private PlatformService platformService;

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return platformService.createUser(user);
    }
}
