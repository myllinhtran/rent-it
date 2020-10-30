package com.rentit.demo.service;

import com.rentit.demo.model.Account;
import com.rentit.demo.model.Category;
import com.rentit.demo.model.Product;
import com.rentit.demo.model.RentedProduct;
import com.rentit.demo.repository.AccountRepository;
import com.rentit.demo.repository.CategoryRepository;
import com.rentit.demo.repository.ProductRepository;
import com.rentit.demo.repository.RentedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
public class PlatformServiceImpl implements PlatformService {

    private AccountRepository accountRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private RentedProductRepository rentedProductRepository;

    @Autowired
    public PlatformServiceImpl(
            AccountRepository accountRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            RentedProductRepository rentedProductRepository
    ) {
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.rentedProductRepository = rentedProductRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account editAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category findCategoryByName(String name) {
        return null;
    }

    @Override
    public Collection<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category editCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(int id) {

    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public Collection<Product> findAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product editProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public RentedProduct findRentedProductById(int id) {
        return null;
    }

    @Override
    public Collection<RentedProduct> findRentedProductByRenter(int id) {
        return null;
    }

    @Override
    public Collection<RentedProduct> findRentedProductByRentee(int id) {
        return null;
    }

    @Override
    public Iterable<RentedProduct> findAllRentedProducts() {
        return null;
    }

    @Override
    public void removeRentedProduct(int id) {

    }


}
