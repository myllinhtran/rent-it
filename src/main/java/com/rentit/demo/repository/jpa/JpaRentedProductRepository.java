package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;

import java.util.List;


public interface JpaRentedProductRepository {

    RentedProduct getProductById(int id);

    List<RentedProduct> getProductByAccount(int id);
}
