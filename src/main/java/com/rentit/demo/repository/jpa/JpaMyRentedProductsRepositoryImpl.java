package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.RentedProduct;
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
    public Collection<RentedProduct> getProductsByUser(Integer id) {
        Query query = this.entityManager.createQuery("SELECT firstName, lastName, email, mobile FROM User user WHERE user.id =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
