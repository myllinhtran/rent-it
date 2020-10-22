package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Product;

public interface JpaProductRepository {

    Product findProductById(int id);
}
