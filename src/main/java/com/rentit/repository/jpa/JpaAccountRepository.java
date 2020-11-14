package com.rentit.repository.jpa;


import com.rentit.model.Account;
import org.springframework.stereotype.Repository;


public interface JpaAccountRepository {

    Account findAccountById(int id);
}
