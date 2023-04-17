package me.durmaz.finalproject.layer.business.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import me.durmaz.finalproject.layer.data.entity.Cart;
import me.durmaz.finalproject.layer.data.entity.Product;

public class CartProductDto {

    private long cartProductId;

    private Cart cartId;

    private Product productId;
    private int salesQuantity;
    /*
    * /cart/get/{id} (Yoksa yarat)
	/cart/add/{cartid}/{productid}
	/cart/remove/{cartid}/{productid}
	/cart/checkout
    *
    *
    * */
    public CartProductDto() {
    }

    public CartProductDto(long cartProductId, Cart cartId, Product productId, int salesQuantity) {
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
