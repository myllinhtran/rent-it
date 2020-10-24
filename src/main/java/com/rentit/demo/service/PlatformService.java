package com.rentit.demo.service;

import com.rentit.demo.model.Account;
import com.rentit.demo.model.Category;
import com.rentit.demo.model.Product;
import com.rentit.demo.model.RentedProduct;

import java.util.Collection;
import java.util.List;


public interface PlatformService {

    Account findAccountById(int id);
    Iterable<Account> findAllAccounts();
    Account createAccount(Account account);
    Account editAccount(Account account);
    void deleteAccount(int id);

    Category findCategoryById(int id);
    Iterable<Category> findAllCategories();
    Category createCategory(Category category);
    Category editCategory(Category category);
    void deleteCategory(int id);

    Product findProductById(int id);
    Iterable<Product> findAllProducts();
    Product createProduct(Product product);
    Product editProduct(Product product);
    void deleteProduct(int id);

    RentedProduct findRentedProductById(int id);
    List<RentedProduct> findRentedProductByAccount(int id);
    Iterable<RentedProduct> findAllRentedProducts();
    void removeRentedProduct(int id);
}
