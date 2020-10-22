package com.rentit.demo.repository.crud;

import com.rentit.demo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface CrudAccountRepository extends CrudRepository<Account, Integer> {
}
