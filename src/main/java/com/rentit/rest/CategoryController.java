package com.rentit.rest;

import com.rentit.model.Category;
import com.rentit.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/categories")
    public ResponseEntity<Collection<Category>> getAllCategories() {
        return ResponseEntity.ok(platformService.findAllCategories());
    }

    @GetMapping(path = "/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        Optional<Category> optionalCategory = platformService.findCategoryById(id);
        if (optionalCategory.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            return ResponseEntity.ok(optionalCategory.get());
        }
    }

    @GetMapping(path = "/categories/category")
    public @ResponseBody Category getCategoryByName(@RequestParam String name) {
        return platformService.findCategoryByName(name);
    }

    @PostMapping(path = "/categories")
    public Category createCategory(@RequestBody Category category) {
        return platformService.createCategory(category);
    }

    @PutMapping(path = "/categories")
    public Category updateCategory(@RequestBody Category category) {
        return platformService.editCategory(category);
    }

    @DeleteMapping(path = "/categories/{id}")
    @ResponseBody
    public String deleteCategory(@PathVariable("id") int id) {
        platformService.deleteCategory(id);
        return MessageFormat.format("Category with ID {0} has been deleted.", id);
    }
}
