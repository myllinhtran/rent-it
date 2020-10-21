package com.rentit.demo.controller;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.MyRentedProductRepository;
import com.rentit.demo.repository.RentedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class RentedProductController {

    @Autowired
    private RentedProductRepository repository;

    @Autowired
    private MyRentedProductRepository repo;

//    @GetMapping(path = "/rentedProducts")
//    public @ResponseBody
//    Iterable<RentedProduct> getAllProducts() {
//        return repository.findAll();
//    }
//
//    @GetMapping(path = "/rentedProducts/{id}")
//    public Optional<RentedProduct> getProduct(@PathVariable("id") Integer id) {
//        return repository.findById(id);
//    }

    @DeleteMapping(path = "/rentedProducts")
    public String removeAllProducts() {
        repository.deleteAll();
        return "All products have been removed.";
    }

    @DeleteMapping(path = "/rentedProducts/{id}")
    public String removeProduct(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return MessageFormat.format("Product with ID {0} has been deleted.", id);
    }

    @GetMapping(path = "/rentedProducts/{id}")
    public List<RentedProduct> getProductRentedByUser(@PathVariable("id") Integer userId) {
        return repo.getProductByUserId(userId);
    }
}
