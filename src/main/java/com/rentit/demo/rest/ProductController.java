package com.rentit.demo.rest;

import com.rentit.demo.model.Product;
import com.rentit.demo.repository.CategoryRepository;
import com.rentit.demo.repository.ProductRepository;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/products")
    public Collection<Product> getAll() {
        return platformService.findAllProducts();
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        Optional<Product> optionalProduct = platformService.findProductById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            return ResponseEntity.ok(optionalProduct.get());
        }
    }

    @PostMapping(path = "/products")
    public Product createProduct(@RequestBody Product product) {
        return platformService.createProduct(product);
    }

    @PutMapping(path = "/products")
    public Product updateProduct(@RequestBody Product product) {
        return platformService.editProduct(product);
    }

    @DeleteMapping(path = "/products/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        platformService.deleteProduct(id);
        return MessageFormat.format("Product with ID {0} has been deleted.", id);
    }
}
