package com.rentit.demo.rest;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.CategoryRepository;
import com.rentit.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<Collection<Category>> getAll() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") int id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            return ResponseEntity.ok(optionalCategory.get());
        }
    }
}
