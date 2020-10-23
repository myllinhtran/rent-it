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
    public RentedProduct getProductById(int id) {
        return this.entityManager.find(RentedProduct.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<RentedProduct> getProductByAccount(int accountId) {
        //SELECT rentedProduct FROM RentedProduct rentedProduct WHERE rentedProduct.renterId.id= :id
        Query query = this.entityManager.createQuery(
                "SELECT categoryId FROM RentedProduct rentedProduct join rentedProduct.categoryId category WHERE rentedProduct.categoryId.id =:id");
        query.setParameter("id", accountId);
        return query.getResultList();
    }
}
