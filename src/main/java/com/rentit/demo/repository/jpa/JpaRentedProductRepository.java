package com.rentit.demo.repository.jpa;

import com.rentit.demo.model.RentedProduct;

import java.util.Collection;


public interface JpaRentedProductRepository {

    RentedProduct getProductById(int id);

    Collection<RentedProduct> getProductByRenter(int id);

    Collection<RentedProduct> getProductByRentee(int id);

    Collection<RentedProduct> getRenterByProduct(int id);
}
