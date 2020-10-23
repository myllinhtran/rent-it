package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;

import java.util.Collection;


public interface JpaRentedProductRepository {

    Collection<RentedProduct> getProductByAccount(Integer id);
}
