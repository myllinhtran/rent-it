package com.rentit.repository.jpa;


import com.rentit.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Integer> {
}
