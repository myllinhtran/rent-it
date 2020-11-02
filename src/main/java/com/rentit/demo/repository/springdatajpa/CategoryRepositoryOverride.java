package com.rentit.demo.repository.springdatajpa;


import com.rentit.demo.model.Category;

public interface CategoryRepositoryOverride {

    Category findCategoryByProduct(int productId);

}
