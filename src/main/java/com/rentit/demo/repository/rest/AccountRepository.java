package com.rentit.demo.repository.rest;

import com.rentit.demo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
