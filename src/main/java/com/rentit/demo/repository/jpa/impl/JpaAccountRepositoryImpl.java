package com.rentit.demo.repository.jpa.impl;

import com.rentit.demo.model.Account;
import com.rentit.demo.repository.jpa.JpaAccountRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class JpaAccountRepositoryImpl implements JpaAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account findAccountById(int id) {
        return this.entityManager.find(Account.class, id);
    }

    @Override
    public Account findRenterByProduct(int id) {
        Query query = this.entityManager.createQuery(
                "SELECT renter FROM RentedProduct rentedProduct join rentedProduct.renter renter on rentedProduct.renter.id = renter.id");
        return ( Account ) query.getSingleResult();
    }

}
