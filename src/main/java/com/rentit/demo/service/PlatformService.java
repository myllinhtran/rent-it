package com.rentit.demo.service;


import com.rentit.demo.model.Account;


public interface PlatformService {

    Account findAccountById(int id);
    Iterable<Account> findAllAccounts();
}
