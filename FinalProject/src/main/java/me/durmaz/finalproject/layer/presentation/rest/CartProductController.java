package me.durmaz.finalproject.layer.presentation.rest;

import me.durmaz.finalproject.layer.business.dto.CartDto;
import me.durmaz.finalproject.layer.business.dto.CartProductDto;
import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.business.dto.UserDto;
import me.durmaz.finalproject.layer.business.mapper.CartProductMapper;
import me.durmaz.finalproject.layer.business.service.CartProductService;
import me.durmaz.finalproject.layer.business.service.ExternalUserServiceImpl;
import me.durmaz.finalproject.layer.data.entity.CartStatus;

import me.durmaz.finalproject.layer.data.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cart")
public class CartProductController {

    private CartProductService cartProductService;

    private ExternalUserServiceImpl externalUserService;

    public CartProductController(CartProductService cartProductService, ExternalUserServiceImpl externalUserService) {
        this.cartProductService = cartProductService;
        this.externalUserService = externalUserService;
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<CartProductDto>> getCart(@PathVariable("userId") long userId) {

        CartDto cartDto;
        User user;



            cartDto = cartProductService.findCart(userId);
            user=externalUserService.getUserById(userId);
            List<CartProductDto> cartProductDtoList;
            if(user==null) {
                return ResponseEntity.notFound().build();
            }



            if (cartDto == null) {





                cartDto=  new CartDto(
                        0,
                        user,
                        String.format("cardnum"),
                        CartStatus.NEW
                );
                cartProductService.addCart(cartDto);

            }
             cartProductDtoList = cartProductService.list(userId);

        return ResponseEntity.ok(cartProductDtoList);

    }

    @PostMapping("/add/{userId}/{productId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> add(@PathVariable("userId") long userId, @PathVariable("productId") long productId) {
        CartDto cartDto = cartProductService.findCart(userId);
        ProductDto productDto = cartProductService.findProduct(productId);
        if(cartDto == null )
        {
           cartDto=  new CartDto(
                    0,
                    externalUserService.getUserById(userId),
                    String.format("cardnum"),
                    CartStatus.NEW
            );
            cartProductService.addCart(cartDto);
        }
        if (cartDto.getCartStatus() == CartStatus.COMPLETED) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart is already completed");
        }

        try {
            CartProductDto cartProductDto = cartProductService.findCartProductByCartIdAndProductId(cartDto, productDto);
            cartProductDto.setSalesQuantity(cartProductDto.getSalesQuantity() + 1);
            cartProductService.change(cartProductDto);
        } catch (NullPointerException e) {
            CartProductDto cartProductDto = new CartProductDto();
            cartProductDto.setCartProductId(0);
            cartProductDto.setCartId(CartProductMapper.toEntity(cartDto));
            cartProductDto.setProductId(CartProductMapper.toEntity(productDto));
            cartProductDto.setSalesQuantity(1);
            cartProductService.add(cartProductDto);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove/{userId}/{productId}")
    @CrossOrigin(origins = "http://localhost:3000")

    public ResponseEntity<String> delete(@PathVariable("userId") long userId, @PathVariable("productId") long productId) {
        try {
            CartProductDto cartProductDto = cartProductService.findCartProductByCartIdAndProductId(cartProductService.findCart(userId), cartProductService.findProduct(productId));
            if (cartProductDto.getSalesQuantity() > 1) {
                cartProductDto.setSalesQuantity(cartProductDto.getSalesQuantity() - 1);
                cartProductService.change(cartProductDto);
            } else {
                cartProductService.deleteCartProduct(cartProductDto.getCartProductId());
            }
            return ResponseEntity.ok().build();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/checkout/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")

    public ResponseEntity<String> checkoutCart(@PathVariable("userId") long userId, @RequestBody String cardNumber) {

           CartDto cartDto = cartProductService.findCart(userId);
            if (cartDto == null) {
                return ResponseEntity.badRequest().build();
            }
            try {
                cartDto.setCartStatus(CartStatus.COMPLETED);
                cartDto.setCardNumber(cardNumber);

                cartProductService.changeCart(cartDto);
                    return ResponseEntity.ok().build();

            }
            catch (NullPointerException e) {
                return ResponseEntity.notFound().build();
            }




    }
    }
