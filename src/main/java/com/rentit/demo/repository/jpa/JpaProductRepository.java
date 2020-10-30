package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaProductRepository extends JpaRepository<Product, Integer> {
}
