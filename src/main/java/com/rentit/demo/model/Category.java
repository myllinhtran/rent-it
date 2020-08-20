package com.rentit.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "categories", schema = "Rentit")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category {" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
