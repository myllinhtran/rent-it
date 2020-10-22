package com.rentit.demo.repository.jpa.impl;


import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;


@Repository
public class JpaMyRentedProductsRepositoryImpl implements JpaRentedProductsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<RentedProduct> getProductsByUser(int id) {
        Query query = this.entityManager.createQuery("SELECT firstName, lastName, email, mobile FROM Account account WHERE account.id =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
