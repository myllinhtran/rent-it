package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.RentedProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;


@Repository
public class JpaMyRentedProductsRepositoryImpl implements MyRentedProductsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<RentedProduct> getProductsByUser() {
        Query query = this.entityManager.createQuery("SELECT firstName FROM User user");
        return query.getResultList();
    }
}
