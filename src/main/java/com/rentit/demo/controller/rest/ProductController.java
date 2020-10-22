package com.rentit.demo.controller.rest;

import com.rentit.demo.model.Product;
import com.rentit.demo.repository.rest.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(path = "/products")
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return repository.findAll(); // This returns a JSON or XML with the renters
    }

    @GetMapping(path = "/products/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping(path = "/products")
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping(path = "/products")
    public Product updateProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping(path = "/products/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") Integer id) throws Exception {
        repository.deleteById(id);
        return MessageFormat.format("Product with ID {0} has been deleted.", id);
    }
}
