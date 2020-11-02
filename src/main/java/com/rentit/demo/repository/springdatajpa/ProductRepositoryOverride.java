package com.rentit.demo.repository.springdatajpa;


import com.rentit.demo.model.Product;

import java.util.Collection;

public interface ProductRepositoryOverride {

    Collection<Product> findAllProducts();
}
