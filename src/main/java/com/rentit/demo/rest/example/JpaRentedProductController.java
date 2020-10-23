package com.rentit.demo.rest.example;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class JpaRentedProductController {

    @Autowired
    JpaRentedProductRepository repository;

    @GetMapping(path = "/myRentedProducts")
    public @ResponseBody Iterable<RentedProduct> getMyProducts() {
        return repository.getProductsByUser(3);
    }
}
