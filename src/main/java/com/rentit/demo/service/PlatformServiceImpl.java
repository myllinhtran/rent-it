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
    @Transactional(readOnly = true)
    public Category findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Category> findAllCategories() {
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
    @Transactional(readOnly = true)
    public Product findProductById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
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
    @Transactional(readOnly = true)
    public RentedProduct findRentedProductById(int id) {
        return rentedProductRepository.getProductById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RentedProduct> findRentedProductByRenter(int id) {
        return rentedProductRepository.getProductByRenter(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RentedProduct> findRentedProductByRentee(int id) {
        return rentedProductRepository.getProductByRentee(id);
    }

    @Override
    public Iterable<RentedProduct> findAllRentedProducts() {
        return null;
    }

    @Override
    public void removeRentedProduct(int id) {

    }
}
