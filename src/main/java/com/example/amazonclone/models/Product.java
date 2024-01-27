package com.example.amazonclone.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "product name is required")
    @Column(name = "ProductName")
    private String productName;

    @NotNull(message = "Product description is required")
    @Column(name = "Description")
    private String description;

    @NotNull(message = "product price is required")
    @Column(name = "Price")
    private double price;

    @NotNull(message = "Please provide product image")
    @Column(name = "ProductImage")
    private String image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
