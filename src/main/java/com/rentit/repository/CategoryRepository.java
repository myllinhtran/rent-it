package com.rentit.repository;

import com.rentit.model.Category;
import com.rentit.repository.jpa.JpaCategoryRepository;
import com.rentit.repository.springdatajpa.CategoryRepositoryOverride;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaCategoryRepository, CrudRepository<Category, Integer>, CategoryRepositoryOverride {
}
