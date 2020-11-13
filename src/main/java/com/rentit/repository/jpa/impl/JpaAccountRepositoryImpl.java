package com.rentit.repository.jpa.impl;

import com.rentit.model.Account;
import com.rentit.repository.jpa.JpaAccountRepository;
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
