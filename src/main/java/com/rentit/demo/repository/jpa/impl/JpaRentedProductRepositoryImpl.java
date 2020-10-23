package com.rentit.demo.repository.jpa.impl;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class JpaRentedProductRepositoryImpl implements JpaRentedProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public RentedProduct getProductById(int id) {
        return this.entityManager.find(RentedProduct.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public Iterable<RentedProduct> getProductByAccount(int id) {
        Query query = entityManager.createQuery("SELECT id, categoryId FROM RentedProduct rentedProduct WHERE rentedProduct.renterId =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
