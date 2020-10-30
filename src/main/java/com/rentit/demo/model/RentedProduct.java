package com.rentit.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rented_products", schema = "Rentit")
public class RentedProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "renter_id")
    private Account renter;

    @OneToOne
    @JoinColumn(name = "rentee_id")
    private Account rentee;

    @Column(name = "address")
    private String address;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getRenter() {
        return renter;
    }

    public void setRenter(Account renter) {
        this.renter = renter;
    }

    public Account getRentee() {
        return rentee;
    }

    public void setRentee(Account rentee) {
        this.rentee = rentee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RentedProduct {" +
               "id=" + id +
               ", categoryId=" + category +
               ", productId=" + product +
               ", renterId=" + renter +
               ", renteeId=" + rentee +
               ", address='" + address + '\'' +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               '}';
    }
}
