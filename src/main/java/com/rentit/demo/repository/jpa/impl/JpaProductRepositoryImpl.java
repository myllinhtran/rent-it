package com.rentit.demo.repository.jpa.impl;

import com.rentit.demo.model.Product;
import com.rentit.demo.repository.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaProductRepositoryImpl implements JpaProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product findProductById(int id) {
        return this.entityManager.find(Product.class, id);
    }
}
