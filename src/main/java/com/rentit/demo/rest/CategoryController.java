package com.rentit.demo.rest;

import com.rentit.demo.model.Category;
import com.rentit.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping(path = "/categories")
    public @ResponseBody
    Iterable<Category> getAllCategories() {
        return repository.findAll(); // This returns a JSON or XML with the renters
    }

    @GetMapping(path = "/categories/{id}")
    public Optional<Category> getCategory(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/categories")
    public Category createCategory(@RequestBody Category category) {
        return repository.save(category);
    }

    @PutMapping(path = "/categories")
    public Category updateRenter(@RequestBody Category category) {
        return repository.save(category);
    }

    @DeleteMapping(path = "/categories/{id}")
    @ResponseBody
    public String deleteCategory(@PathVariable("id") Integer id) throws Exception {
        repository.deleteById(id);
        return MessageFormat.format("Category with ID {0} has been deleted.", id);
    }
}
