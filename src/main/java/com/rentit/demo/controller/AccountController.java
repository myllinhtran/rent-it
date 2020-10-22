package com.rentit.demo.controller;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @GetMapping(path = "/accounts")
    public @ResponseBody
    Iterable<Account> getAllAccounts() {
        return repository.findAll();
    }

    @GetMapping(path = "/accounts/{id}")
    public Optional<Account> getAccount(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/accounts")
    public Account createAccount(@RequestBody Account account) {
        return repository.save(account);
    }

    @PutMapping(path = "/accounts")
    public Account updateAccount(@RequestBody Account account) {
        return repository.save(account);
    }

    @DeleteMapping(path = "/accounts/{id}")
    @ResponseBody
    public String deleteAccount(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return MessageFormat.format("Account with ID {0} has been deleted.", id);
    }
}
