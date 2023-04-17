package me.durmaz.finalproject.layer.data.entity;

import jakarta.persistence.*;
import me.durmaz.finalproject.layer.data.entity.User;

/*
 Cart
    cartId c
    ustomerName
    cardNumber
    cartStatus (Enum: NEW, COMPLETED)
 add this field to code
*/
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
    private String cardNumber;
    private CartStatus cartStatus;

    public Cart() {
    }

    public Cart(long cartId, User userId, String cardNumber, CartStatus cartStatus) {
        this.cartId = cartId;
        this.userId = userId;
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
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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