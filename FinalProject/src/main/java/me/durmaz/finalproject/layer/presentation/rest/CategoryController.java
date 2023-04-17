package me.durmaz.finalproject.layer.presentation.rest;

import me.durmaz.finalproject.layer.business.service.CategoryService;
import me.durmaz.finalproject.layer.business.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
         //TODO tüm responsları varsayılan hale getir.
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryDtoList = categoryService.list();
        if(categoryDtoList.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(categoryDtoList);
        }
    }


}
