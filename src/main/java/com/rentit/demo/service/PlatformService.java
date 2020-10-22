package com.rentit.demo.service;


import com.rentit.demo.model.Account;


public interface PlatformService {

    Account findAccountById(int id);
    Iterable<Account> findAllAccounts();
    Account createAccount(Account account);
    Account editAccount(Account account);
    void deleteAccount(int id);
}
