package com.rentit.repository;

import com.rentit.model.RentedProduct;
import com.rentit.repository.jpa.JpaRentedProductRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentedProductRepository extends JpaRentedProductRepository, CrudRepository<RentedProduct, Integer> {
}
