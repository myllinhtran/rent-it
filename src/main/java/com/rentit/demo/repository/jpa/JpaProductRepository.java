package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Product;

import java.util.Collection;

public interface JpaProductRepository {

    Product findProductById(int id);

    Collection<Product> findAllProducts();
}
