package com.rentit.demo.rest;

import com.rentit.demo.model.Product;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Collection;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/products")
    public @ResponseBody
    Collection<Product> getAllProducts() {
        return platformService.findAllProducts();
    }

    @GetMapping(path = "/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return platformService.findProductById(id);
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
    @ResponseBody
    public String deleteProduct(@PathVariable("id") Integer id) throws Exception {
        platformService.deleteProduct(id);
        return MessageFormat.format("Product with ID {0} has been deleted.", id);
    }
}
