package com.rentit.demo.rest;

import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class RentedProductController {

    @Autowired
    private PlatformService platformService;

    @GetMapping(path = "/api/v1/rented-products/{id}")
    public @ResponseBody
    RentedProduct getRentedProduct(@PathVariable("id") int id) {
        return platformService.findRentedProductById(id);
    }

    @GetMapping(path = "/accounts/{id}/rented-products")
    public Collection<RentedProduct> getRentedProductByAccount(@PathVariable("id") int id) {
        return platformService.findRentedProductByAccount(id);
    }
}
