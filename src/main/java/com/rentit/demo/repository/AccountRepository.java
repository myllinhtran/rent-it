package com.rentit.demo.repository;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.jpa.JpaAccountRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends JpaAccountRepository, CrudRepository<Account, Integer> {
}
