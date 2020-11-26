package com.rentit.repository.jpa;


import com.rentit.model.Account;


public interface JpaAccountRepository {

    Account findAccountById(int id);
}
