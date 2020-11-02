package com.rentit.demo.repository;

import com.rentit.demo.model.Product;
import com.rentit.demo.repository.jpa.JpaProductRepository;
import com.rentit.demo.repository.springdatajpa.ProductRepositoryOverride;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaProductRepository, CrudRepository<Product, Integer>, ProductRepositoryOverride {
}
