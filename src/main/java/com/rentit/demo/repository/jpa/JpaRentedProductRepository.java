package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;



public interface JpaRentedProductRepository {

    RentedProduct getProductById(int id);
    Iterable<RentedProduct> getProductByAccount(int id);
}
