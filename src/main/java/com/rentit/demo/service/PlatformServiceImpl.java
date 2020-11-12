package com.rentit.demo.service;

import com.rentit.demo.model.*;
import com.rentit.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
public class PlatformServiceImpl implements PlatformService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private RentedProductRepository rentedProductRepository;

    @Autowired
    public PlatformServiceImpl(
            UserRepository userRepository,
            AccountRepository accountRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            RentedProductRepository rentedProductRepository
    ) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.rentedProductRepository = rentedProductRepository;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.add(user);
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
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
        return categoryRepository.getCategoryByName(name);
    }

    @Override
    public Collection<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Collection<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public RentedProduct findRentedProductById(int id) {
        return rentedProductRepository.getProductById(id);
    }

    @Override
    public Collection<RentedProduct> findRentedProductByRenter(int id) {
        return rentedProductRepository.getProductByRenter(id);
    }

    @Override
    public Collection<RentedProduct> findRentedProductByRentee(int id) {
        return rentedProductRepository.getProductByRentee(id);
    }

    @Override
    public Iterable<RentedProduct> findAllRentedProducts() {
        return rentedProductRepository.findAll();
    }

    @Override
    @Transactional
    public void removeRentedProduct(int id) {
    }

    @Override
    public RentedProduct findRenterByProduct(int id) {
        return rentedProductRepository.getRenterByProduct(id);
    }
}
