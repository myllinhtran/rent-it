package com.rentit.repository.jpa;

import com.rentit.model.RentedProduct;

import java.util.Collection;


public interface JpaRentedProductRepository {

    RentedProduct getProductById(int id);

    Collection<RentedProduct> getProductByRenter(int id);

    Collection<RentedProduct> getProductByRentee(int id);

    RentedProduct getRenterByProduct(int id);
}
