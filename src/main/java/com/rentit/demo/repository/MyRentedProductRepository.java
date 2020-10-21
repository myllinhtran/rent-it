package com.rentit.demo.repository;


import com.rentit.demo.model.RentedProduct;

import java.util.List;

public interface MyRentedProductRepository {

    List<RentedProduct> getProductByUserId(Integer userId);
}
