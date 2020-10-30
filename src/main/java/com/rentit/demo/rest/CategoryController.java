package com.rentit.demo.rest;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.CategoryRepository;
import com.rentit.demo.repository.ProductRepository;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/categories")
    public ResponseEntity<Collection<Category>> getAll() {
        return ResponseEntity.ok(platformService.findAllCategories());
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") int id) {
        Optional<Category> optionalCategory = platformService.findCategoryById(id);
        if (optionalCategory.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            return ResponseEntity.ok(optionalCategory.get());
        }
    }
}
