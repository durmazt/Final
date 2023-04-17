package me.durmaz.finalproject.layer.data.repository;

import me.durmaz.finalproject.layer.business.dto.CartDto;
import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.data.entity.Cart;
import me.durmaz.finalproject.layer.data.entity.CartProduct;
import me.durmaz.finalproject.layer.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    @Query("select p from CartProduct p where p.cartProductId = :cartProductId")
    List<CartProduct> findAllByCartProductId(@Param("cartProductId")long cartProductId);

    @Query("select c from CartProduct c where c.cartId.cartId = :cartId")
    List<CartProduct> findAllByCartId(@Param("cartId")long cartId);
    @Query("select c from CartProduct c where c.cartId.userId.id = :userId and c.cartId.cartStatus = 0")
    List<CartProduct> findAllByUserId(@Param("userId") long userId);
    @Query("select c from CartProduct c where c.cartId.cartId = :cartId")
    CartProduct findByCartId(@Param("cartId")long cartId);
    @Query("select cp from CartProduct cp where cp.cartId = :cartId and cp.productId = :productId")
    CartProduct findCartProductByCartIdAndProductId(@Param("cartId") Cart cartId, @Param("productId") Product productId);
    @Query("select c from Cart c where c.cardNumber = :cardNumber")
    Cart findByCartNumber(@Param("cardNumber")String cardNumber);

}
