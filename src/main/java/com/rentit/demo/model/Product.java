package com.rentit.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "Rentit")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "price_per_day")
    private Integer pricePerDay;

    @Column(name = "description")
    private String description;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product {" +
               "id=" + id +
               ", categoryId=" + categoryId +
               ", name='" + name + '\'' +
               ", pricePerDay=" + pricePerDay +
               ", description='" + description + '\'' +
               '}';
    }
}
