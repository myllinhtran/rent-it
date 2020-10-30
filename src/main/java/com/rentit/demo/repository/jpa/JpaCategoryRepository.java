package com.rentit.demo.repository.jpa;


import com.rentit.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Integer> {
}
