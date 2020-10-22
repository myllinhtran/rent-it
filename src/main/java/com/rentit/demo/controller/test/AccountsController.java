package com.rentit.demo.controller.test;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountsController {

    @Autowired
    private AccountRepo repo;

    @GetMapping("/account/{id}")
    public @ResponseBody
    Collection<Account> getAccount(@PathVariable("id") Integer id) {
        return repo.findAccountById(3);
    }
}
