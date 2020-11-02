package com.rentit.demo.repository.springdatajpa.impl;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.springdatajpa.CategoryRepositoryOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class CategoryRepositoryOverrideImpl implements CategoryRepositoryOverride {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Category findCategoryByProduct(int productId) {
        Query query = this.entityManager.createQuery(
                "SELECT product, category FROM Product product join product.category category on category.id = product.category.id WHERE product.id = :id");
        query.setParameter("id", productId);
        return ( Category ) query.getSingleResult();
    }
}
