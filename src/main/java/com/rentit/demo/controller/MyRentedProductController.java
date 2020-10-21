package com.rentit.demo.controller;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.MyRentedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class MyRentedProductController {

    @Autowired
    MyRentedProductsRepository repository;

    @GetMapping(path = "/myRentedProducts")
    public @ResponseBody Iterable<RentedProduct> getMyProducts() {
        return repository.getProductsByUser(3);
    }
}
