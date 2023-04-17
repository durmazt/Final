package me.durmaz.finalproject.layer.data.repository;

import me.durmaz.finalproject.layer.data.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartRepository<C, L extends Number> extends CrudRepository<Cart, Long> {

    @Query("select c from Cart c where c.userId.userId = :userId and c.cartStatus =0")
    Cart findByCartId(@Param("userId")long userId);
}
