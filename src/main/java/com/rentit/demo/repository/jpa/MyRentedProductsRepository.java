package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;

import java.util.Collection;


public interface MyRentedProductsRepository {

    Collection<RentedProduct> getProductsByUser(Integer id);
}
