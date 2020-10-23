package com.rentit.demo.repository;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentedProductRepository extends JpaRentedProductRepository, CrudRepository<RentedProduct, Integer> {
}
