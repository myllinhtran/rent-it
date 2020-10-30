package com.rentit.demo.rest;

import com.rentit.demo.repository.CategoryRepository;
import com.rentit.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
}
