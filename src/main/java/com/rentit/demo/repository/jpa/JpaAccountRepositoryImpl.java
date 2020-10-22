package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JpaAccountRepositoryImpl implements JpaAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account findAccountById(int id) {
        return this.entityManager.find(Account.class, id);
    }
}
