package me.durmaz.finalproject.layer.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;

    private double salesPrice;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;
    private String imageUrl;

    public Product() {
    }

    public Product(long productId, String productName, double salesPrice, Category categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
        this.categoryId = categoryId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
