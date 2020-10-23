package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;

import java.util.Collection;


public interface JpaRentedProductRepository {

    RentedProduct getProductById(int id);
    Collection<RentedProduct> getProductByAccount(int id);
}
