package me.durmaz.finalproject.layer.business.mapper;

import me.durmaz.finalproject.layer.business.dto.CartDto;
import me.durmaz.finalproject.layer.business.dto.CartProductDto;
import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.business.dto.UserDto;
import me.durmaz.finalproject.layer.data.entity.Cart;
import me.durmaz.finalproject.layer.data.entity.CartProduct;
import me.durmaz.finalproject.layer.data.entity.Product;
import me.durmaz.finalproject.layer.data.entity.User;

public class CartProductMapper {
    //TODO: implement this class to other classes that have similar methods
    public static Cart toEntity(CartDto cartDto)
    {
        Cart cart=new Cart();
        cart.setCartId(cartDto.getCartId());
        cart.setCardNumber(cartDto.getCardNumber());
        cart.setUserId(cartDto.getUserId());
        cart.setCartStatus(cartDto.getCartStatus());
        return cart;
    }
    public static Product toEntity(ProductDto productDto) {
        Product product=new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        product.setCategoryId(productDto.getCategoryId());
        product.setImageUrl(productDto.getImageUrl());

        return product;
    }
    public static CartDto toDto(Cart cart)
    {
        CartDto cartDto=new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setCardNumber(cart.getCardNumber());
        cartDto.setUserId(cart.getUserId());
        cartDto.setCartStatus(cart.getCartStatus());
        return cartDto;
    }
    public static ProductDto toDto(Product product)
    {
        ProductDto  productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        productDto.setCategoryId(product.getCategoryId());
        productDto.setImageUrl(product.getImageUrl());

        return productDto;
    }
    public static CartProductDto toDto(CartProduct cartProduct)
    {
        CartProductDto cartProductDto=new CartProductDto();
        cartProductDto.setCartProductId(cartProduct.getCartProductId());
        cartProductDto.setCartId(cartProduct.getCartId());
        cartProductDto.setProductId(cartProduct.getProductId());
        cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
        return cartProductDto;
    }
    public static CartProduct toEntity(CartProductDto cartProductDto)
    {
        CartProduct cartProduct=new CartProduct();
        cartProduct.setCartProductId(cartProductDto.getCartProductId());
        cartProduct.setCartId(cartProductDto.getCartId());
        cartProduct.setProductId(cartProductDto.getProductId());
        cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
        return cartProduct;
    }
    public static  User toEntity(UserDto userDto)
    {
        User user=new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());

        return user;
    }


}
