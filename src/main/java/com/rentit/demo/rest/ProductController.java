package com.rentit.demo.rest;

import com.rentit.demo.model.Product;
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
public class ProductController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/products")
    public ResponseEntity<Collection<Product>> getAll() {
        return ResponseEntity.ok(platformService.findAllProducts());
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
}
