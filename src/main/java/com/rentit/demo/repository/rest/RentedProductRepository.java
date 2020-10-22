package com.rentit.demo.repository.rest;


import com.rentit.demo.model.RentedProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface RentedProductRepository extends CrudRepository<RentedProduct, Integer> {
}
