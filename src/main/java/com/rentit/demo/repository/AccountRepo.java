package com.rentit.demo.repository;

import com.rentit.demo.repository.crud.CrudAccountRepository;
import com.rentit.demo.repository.jpa.JpaAccountRepository;

public interface AccountRepo extends JpaAccountRepository, CrudAccountRepository {
}
