package me.durmaz.finalproject.layer.business.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import me.durmaz.finalproject.layer.data.entity.CartStatus;
import me.durmaz.finalproject.layer.data.entity.User;

public class CartDto {

    private long cartId;

    private User UserId;
    private String cardNumber;
    private CartStatus cartStatus;

    public CartDto() {
    }

    public CartDto(long cartId, User userId, String cardNumber, CartStatus cartStatus) {
        this.cartId = cartId;
        this.UserId = userId;
        this.cardNumber = cardNumber;
        this.cartStatus = cartStatus;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public User getUserId() {
        return UserId;
    }

    public void setUserId(User userId) {
        UserId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
