package com.rentit.demo.service;

import com.rentit.demo.model.Account;
import com.rentit.demo.model.Category;
import com.rentit.demo.repository.AccountRepository;
import com.rentit.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;


@Service
public class PlatformServiceImpl implements PlatformService {

    private AccountRepository accountRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public PlatformServiceImpl(
            AccountRepository accountRepository,
            CategoryRepository categoryRepository
    ) {
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
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

    @Override
    @Transactional
    public Account editAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
        MessageFormat.format("Account with ID {0} has been deleted.", id);
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
        MessageFormat.format("Category with ID {0} has been deleted.", id);
    }
}
