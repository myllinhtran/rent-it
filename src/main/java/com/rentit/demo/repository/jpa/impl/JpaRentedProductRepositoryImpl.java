package com.rentit.demo.repository.jpa.impl;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;


@Repository
public class JpaRentedProductRepositoryImpl implements JpaRentedProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<RentedProduct> getProductByAccount() {
        Query query = this.entityManager.createQuery("SELECT firstName FROM Account account");
        return query.getResultList();
    }
}
