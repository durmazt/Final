package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.business.dto.CartDto;
import me.durmaz.finalproject.layer.business.dto.CartProductDto;
import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.data.entity.Cart;
import me.durmaz.finalproject.layer.data.entity.Product;

import java.util.List;

public interface CartProductService {

    public void add(CartProductDto CartProductDto);

    public void addCart(CartDto cartDto);
    public void change(CartProductDto CartProductDto);
    public void deleteCartProduct(long productId);
    public void deleteCheckoutedCartProduct(long cartId);
    public CartProductDto findCartProduct(long productId);

    public CartDto findCart(long userId);

    public ProductDto findProduct(long productId);
    public CartProductDto findCartProductByCartIdAndProductId(CartDto cartId, ProductDto productId);
//    public CartDto findByCartNumber(String cardNumber); @depracted to use findCart
    public List<CartProductDto> list(long userId);

    public void changeCart(CartDto cartDto);
}
