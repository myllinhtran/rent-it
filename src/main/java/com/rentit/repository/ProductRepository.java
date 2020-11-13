package com.rentit.repository;

import com.rentit.model.Product;
import com.rentit.repository.jpa.JpaProductRepository;
import com.rentit.repository.springdatajpa.ProductRepositoryOverride;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaProductRepository, CrudRepository<Product, Integer>, ProductRepositoryOverride {
}
