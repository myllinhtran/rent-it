package com.rentit.repository;

import com.rentit.model.Account;
import com.rentit.repository.jpa.JpaAccountRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends JpaAccountRepository, CrudRepository<Account, Integer> {
}
