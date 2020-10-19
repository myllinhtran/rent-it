package com.rentit.demo.repository;

import com.rentit.demo.model.RentedProduct;
import org.springframework.data.repository.CrudRepository;

public interface RentedProductRepository extends CrudRepository<RentedProduct, Integer> {
}
