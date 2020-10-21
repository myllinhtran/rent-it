package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.RentedProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaMyRentedProductsRepositoryImpl implements MyRentedProductsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<RentedProduct> getProductsByUser(Integer userId) {
        Query query = this.entityManager.createQuery("SELECT name FROM rentit.users WHERE rentit.users.id =:userId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
