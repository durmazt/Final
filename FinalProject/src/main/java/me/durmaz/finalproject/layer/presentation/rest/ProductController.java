package me.durmaz.finalproject.layer.presentation.rest;

import me.durmaz.finalproject.layer.business.service.ProductService;
import me.durmaz.finalproject.layer.business.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") long productId)
    {
        ProductDto productDto = productService.find(productId);
        if(productDto == null)
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(productDto);
        }
    }
    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<ProductDto>> getList(@PathVariable("categoryId") long categoryId)
    {
        List<ProductDto> productDtoList = productService.list(categoryId);
        if(productDtoList.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(productDtoList);
        }
    }


}
