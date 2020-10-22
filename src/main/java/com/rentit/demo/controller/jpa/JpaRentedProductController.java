package com.rentit.demo.controller.jpa;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.jpa.JpaRentedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class JpaRentedProductController {

    @Autowired
    JpaRentedProductsRepository repository;

    @GetMapping(path = "/myRentedProducts")
    public @ResponseBody Iterable<RentedProduct> getMyProducts() {
        return repository.getProductsByUser(3);
    }
}
