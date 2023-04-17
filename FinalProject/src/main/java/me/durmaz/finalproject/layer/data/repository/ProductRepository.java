package me.durmaz.finalproject.layer.data.repository;

import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {



    @Query("select p from Product p where p.categoryId.categoryId = :categoryId")
    List<Product> findAllByCategoryId(long categoryId);
}
