package com.rentit.demo.repository;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.jpa.JpaCategoryRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaCategoryRepository, CrudRepository<Category, Integer>, CategoryRepositoryOverride {
}
