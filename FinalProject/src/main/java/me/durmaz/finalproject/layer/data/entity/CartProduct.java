package me.durmaz.finalproject.layer.data.entity;

import jakarta.persistence.*;

//cartProductId cartId productId salesQuantity
@Entity
@Table(name = "cart_product")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cartId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product productId;

    private int salesQuantity;

    public CartProduct() {
    }

    public CartProduct(long cartProductId, Cart cartId, Product productId, int salesQuantity) {
        this.cartProductId = cartProductId;
        this.cartId = cartId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
