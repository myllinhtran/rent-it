package com.rentit.repository.springdatajpa;


import com.rentit.model.Product;

import java.util.Collection;

public interface ProductRepositoryOverride {

    Collection<Product> findAllProducts();
}
