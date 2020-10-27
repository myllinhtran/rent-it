package com.rentit.demo.repository.jpa.impl;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.jpa.JpaCategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class JpaCategoryRepositoryImpl implements JpaCategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category findCategoryById(int id) {
        return this.entityManager.find(Category.class, id);
    }

    @Override
    public Category findCategoryByName(String name) {
        Query query = this.entityManager.createQuery("SELECT category FROM Category category WHERE category.name =:name");
        query.setParameter("name", name);
        return ( Category ) query.getSingleResult();
    }
}
