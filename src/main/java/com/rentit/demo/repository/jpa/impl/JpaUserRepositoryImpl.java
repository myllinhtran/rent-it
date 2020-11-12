package com.rentit.demo.repository.jpa.impl;


import com.rentit.demo.model.User;
import com.rentit.demo.repository.jpa.JpaUserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JpaUserRepositoryImpl implements JpaUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User add(User user) throws DataAccessException {
        if (this.entityManager.find(User.class, user.getUsername()) != null) {
            this.entityManager.persist(user);
        }
        else {
            this.entityManager.merge(user);
        }
        return user;
    }
}
