package com.rentit.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rented_products")
public class RentedProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @OneToOne
    @JoinColumn(name = "renter_id")
    private Renter renterId;

    @OneToOne
    @JoinColumn(name = "rentee_id")
    private Rentee renteeId;

    @Column(name = "address")
    private String address;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Renter getRenterId() {
        return renterId;
    }

    public void setRenterId(Renter renterId) {
        this.renterId = renterId;
    }

    public Rentee getRenteeId() {
        return renteeId;
    }

    public void setRenteeId(Rentee renteeId) {
        this.renteeId = renteeId;
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
               ", categoryId=" + categoryId +
               ", productId=" + productId +
               ", renterId=" + renterId +
               ", renteeId=" + renteeId +
               ", address='" + address + '\'' +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               '}';
    }
}
