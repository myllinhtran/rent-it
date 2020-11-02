package com.rentit.demo.repository.springdatajpa;

import com.rentit.demo.model.Category;

public interface CategoryRepositoryOverride {

    Category getCategoryByName(String name);
}
