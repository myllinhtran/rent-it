package com.rentit.demo.controller;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.MyRentedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class MyRentedProductController {

    @Autowired
    MyRentedProductsRepository repository;

    @GetMapping(path = "/myRentedProducts")
    public @ResponseBody Iterable<RentedProduct> getMyProducts() {
        return repository.getProductsByUser();
    }
}
