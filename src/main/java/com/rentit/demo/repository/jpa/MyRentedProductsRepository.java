package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;

import java.util.List;


public interface MyRentedProductsRepository {

    List<RentedProduct> getProductsByUser(Integer userId);
}
