package com.rentit.demo.controller.test;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountsController {

    @Autowired
    private AccountRepo repo;

    @GetMapping(path = "/account/{id}")
    public @ResponseBody
    Account getAccount(@PathVariable("id") int id) {
        return repo.findAccountById(id);
    }
}
