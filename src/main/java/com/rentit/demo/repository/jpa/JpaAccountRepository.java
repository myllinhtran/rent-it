package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Account;

import java.util.Collection;

public interface JpaAccountRepository {

    Collection<Account> findAccountById(int id);
}
