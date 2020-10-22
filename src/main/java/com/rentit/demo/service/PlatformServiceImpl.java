package com.rentit.demo.service;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PlatformServiceImpl implements PlatformService {

    private AccountRepository accountRepository;

    @Autowired
    public PlatformServiceImpl (
            AccountRepository accountRepository
    ) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

}
