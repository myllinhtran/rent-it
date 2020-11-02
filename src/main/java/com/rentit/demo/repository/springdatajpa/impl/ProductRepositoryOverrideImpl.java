package com.rentit.demo.repository.springdatajpa.impl;

import com.rentit.demo.model.Product;
import com.rentit.demo.repository.springdatajpa.ProductRepositoryOverride;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class ProductRepositoryOverrideImpl implements ProductRepositoryOverride {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> findAllProducts() {
        Query query = this.entityManager.createQuery("SELECT product FROM Product product");
        return query.getResultList();
    }
}
