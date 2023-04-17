package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.data.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    /*
        public void add(ProductDto productDto);
        public void change(ProductDto productDto);
        public void deleteProduct(long productId);


        these methode are not necessary for this class but maybe will
    */
    public ProductDto find(long productId);


    public List<ProductDto> list(long categoryId);


}
