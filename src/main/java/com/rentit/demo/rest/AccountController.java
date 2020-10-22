package com.rentit.demo.rest;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.AccountRepository;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/accounts")
    public @ResponseBody
    Iterable<Account> getAccounts() {
        return platformService.findAllAccounts();
    }

    @GetMapping(path = "/accounts/{id}")
    public @ResponseBody
    Account getAccount(@PathVariable("id") int id) {
        return platformService.findAccountById(id);
    }

    /*@GetMapping(path = "/accounts")
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
    }*/
}
