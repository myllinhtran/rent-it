package com.rentit.repository.jpa;


import com.rentit.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category, Integer> {
}
