package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.MyRentedProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaMyRentedProductImpl implements MyRentedProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<RentedProduct> getProductByUserId(Integer userId) {
        return null;
        // this.em.createQuery("SELECT * FROM rentit.rented_products").getResultList();
    }
}
