package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Account;


public interface JpaAccountRepository {

    Account findAccountById(int id);
}
