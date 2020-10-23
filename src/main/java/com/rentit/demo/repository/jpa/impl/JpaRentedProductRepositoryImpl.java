package com.rentit.demo.repository.jpa.impl;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JpaRentedProductRepositoryImpl implements JpaRentedProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RentedProduct getProductById(int id) {
        return this.entityManager.find(RentedProduct.class, id);
    }
}
