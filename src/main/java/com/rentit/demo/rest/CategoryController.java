package com.rentit.demo.rest;

import com.rentit.demo.model.Category;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/categories")
    public @ResponseBody
    Iterable<Category> getAllCategories() {
        return platformService.findAllCategories(); // This returns a JSON or XML with the renters
    }

    @GetMapping(path = "/categories/{id}")
    public Category getCategory(@PathVariable("id") Integer id) {
        return platformService.findCategoryById(id);
    }

    @GetMapping(path = "/categories/{category}")
    public Category getCategoryByName(@PathVariable("category") String category) {
        return platformService.findCategoryByName(category);
    }

    @PostMapping(path = "/categories")
    public Category createCategory(@RequestBody Category category) {
        return platformService.createCategory(category);
    }

    @PutMapping(path = "/categories")
    public Category updateRenter(@RequestBody Category category) {
        return platformService.editCategory(category);
    }

    @DeleteMapping(path = "/categories/{id}")
    @ResponseBody
    public String deleteCategory(@PathVariable("id") Integer id) {
        platformService.deleteCategory(id);
        return MessageFormat.format("Category with ID {0} has been deleted.", id);
    }
}
