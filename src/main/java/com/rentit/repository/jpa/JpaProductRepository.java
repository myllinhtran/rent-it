package com.rentit.repository.jpa;


import com.rentit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaProductRepository extends JpaRepository<Product, Integer> {
}
