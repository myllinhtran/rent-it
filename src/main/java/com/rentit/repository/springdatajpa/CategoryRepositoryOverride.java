package com.rentit.repository.springdatajpa;

import com.rentit.model.Category;

public interface CategoryRepositoryOverride {

    Category getCategoryByName(String name);
}
