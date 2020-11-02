package com.rentit.demo.repository.springdatajpa.impl;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.springdatajpa.CategoryRepositoryOverride;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CategoryRepositoryOverrideImpl implements CategoryRepositoryOverride {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category getCategoryByName(String category) {
        Query query = this.entityManager.createQuery("SELECT category FROM Category category WHERE category.name =:category");
        query.setParameter("category", category);
        return ( Category ) query.getSingleResult();
    }
}
