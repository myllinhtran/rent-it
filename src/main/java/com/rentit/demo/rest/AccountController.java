package com.rentit.demo.rest;

import com.rentit.demo.model.Account;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;


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

    @PostMapping(path = "/accounts")
    public Account addAccount(@RequestBody Account account) {
        return platformService.createAccount(account);
    }

    @PutMapping(path = "/accounts")
    public Account updateAccount(@RequestBody Account account) {
        return platformService.editAccount(account);
    }

    @DeleteMapping(path = "/accounts/{id}")
    @ResponseBody
    public String deleteAccount(@PathVariable("id") int id) {
        platformService.deleteAccount(id);
        return MessageFormat.format("Account with ID {0} has been deleted.", id);
    }

    @GetMapping(path = "/accounts/rented-products")
    public Account getRenterByProduct(@RequestParam int productId) {
        return platformService.findRenterByProduct(productId);
    }

}
