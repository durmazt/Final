package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.business.dto.CartDto;
import me.durmaz.finalproject.layer.business.dto.CartProductDto;
import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.business.mapper.CartProductMapper;
import me.durmaz.finalproject.layer.data.entity.Cart;
import me.durmaz.finalproject.layer.data.entity.CartProduct;
import me.durmaz.finalproject.layer.data.entity.Product;
import me.durmaz.finalproject.layer.data.repository.CartProductRepository;
import me.durmaz.finalproject.layer.data.repository.CartRepository;
import me.durmaz.finalproject.layer.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService{

    private CartProductRepository cartProductRepository;
    private CartRepository cartRepository;

    private ProductRepository productRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartProductRepository = cartProductRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }
    @Override
    public void add(CartProductDto cartProductDto) {
        if(findCartProduct(cartProductDto.getCartProductId())==null)
            cartProductRepository.save(CartProductMapper.toEntity(cartProductDto));
        else
        {
            cartProductDto.setSalesQuantity(cartProductDto.getSalesQuantity()+1);
            change(cartProductDto);
        }
    }


    @Override
    public void addCart(CartDto cartDto) {
        cartRepository.save(CartProductMapper.toEntity(cartDto));
    }

    @Override
    public void change(CartProductDto CartProductDto) {
        cartProductRepository.save(CartProductMapper.toEntity(CartProductDto));
    }

    @Override
    public void changeCart(CartDto cartDto) {
        cartRepository.save(CartProductMapper.toEntity(cartDto));
    }


    @Override
    public void deleteCartProduct(long productId) {
        Optional<CartProduct> cartProduct = cartProductRepository.findById(productId);
        if(cartProduct.isPresent()){
            cartProductRepository.delete(cartProduct.get());
        }
        //TODO: throw exception or return false or logger


    }
    @Override
    public void deleteCheckoutedCartProduct(long cartId) {

        deleteCartProduct(cartId);

    }

    @Override
    public CartProductDto findCartProduct(long cartProductId) {
        Optional<CartProduct> cartProduct = cartProductRepository.findById(cartProductId);
        if(cartProduct.isPresent()){
            return CartProductMapper.toDto(cartProduct.get());
        }

        return null;
    }

    @Override
    public CartProductDto findCartProductByCartIdAndProductId(CartDto cartId, ProductDto productId) {
        try {
            CartProduct cartProduct = cartProductRepository
                    .findCartProductByCartIdAndProductId(
                            CartProductMapper.toEntity(cartId), CartProductMapper.toEntity(productId));
            return CartProductMapper.toDto(cartProduct);
        }
        catch (Exception e)
        {
            //TODO: logger
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public CartDto findCart(long userId) {
        Cart cart = new Cart();
        cart=cartRepository.findByCartId(userId);
        if(cart!=null)
        {
            return CartProductMapper.toDto(cart);
        }else{
            //TODO ExceptionHandler
        }

        return null;
    }

    @Override
    public ProductDto findProduct(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent())
        {
            return CartProductMapper.toDto(product.get());
        }
        return null;
    }

    @Override
    public List<CartProductDto> list(long userId) {
        List<CartProductDto> cartProductDtoList= new ArrayList<>();
        for(CartProduct cartProduct: cartProductRepository.findAllByUserId(userId))
        {
            cartProductDtoList.add(CartProductMapper.toDto(cartProduct));
        }
        return cartProductDtoList;
    }
}
