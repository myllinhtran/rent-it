package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Category;

public interface JpaCategoryRepository {

    Category findCategoryById(int id);

    Category findCategoryByName(String name);
}
