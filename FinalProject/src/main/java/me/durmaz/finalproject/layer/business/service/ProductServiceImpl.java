package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.business.dto.ProductDto;
import me.durmaz.finalproject.layer.business.mapper.CartProductMapper;
import me.durmaz.finalproject.layer.data.entity.Cart;
import me.durmaz.finalproject.layer.data.entity.Product;
import me.durmaz.finalproject.layer.data.repository.CartProductRepository;
import me.durmaz.finalproject.layer.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }
    @Override
    public ProductDto find(long productId) {
        Optional<Product> optional= productRepository.findById(productId);
        if(optional.isPresent())
        {
            return CartProductMapper.toDto(optional.get());
        }
        return null;
    }


    @Override
    public List<ProductDto> list(long cateogryId) {
        List<ProductDto> productDtoList= new ArrayList<>();
        for(Product product: productRepository.findAllByCategoryId(cateogryId))
        {
                productDtoList.add(CartProductMapper.toDto(product));
        }

        return productDtoList;
    }




}
