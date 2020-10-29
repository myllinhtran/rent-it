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
    Category findCategoryByName(String name);
    Iterable<Category> findAllCategories();
    Category createCategory(Category category);
    Category editCategory(Category category);
    void deleteCategory(int id);

    Product findProductById(int id);
    List<Product> findAllProducts();
    Product createProduct(Product product);
    Product editProduct(Product product);
    void deleteProduct(int id);

    RentedProduct findRentedProductById(int id);
    Collection<RentedProduct> findRentedProductByRenter(int id);
    Collection<RentedProduct> findRentedProductByRentee(int id);
    Iterable<RentedProduct> findAllRentedProducts();
    void removeRentedProduct(int id);
}
