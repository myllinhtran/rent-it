package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JpaAccountRepositoryImpl implements JpaAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Account> findAccountById(int id) {
        Query query = this.entityManager.createQuery("SELECT firstName, lastName, email, mobile FROM Account account WHERE account.id =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
