package com.rentit.demo.controller;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.RentedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RentedProductController {

    @Autowired
    private RentedProductRepository repository;

    @GetMapping(path = "/rentedProducts")
    public @ResponseBody Iterable<RentedProduct> getAllRentedProducts() {
        return repository.findAll();
    }
}
