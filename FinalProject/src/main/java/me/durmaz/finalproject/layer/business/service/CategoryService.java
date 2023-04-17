package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.business.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    /*
        public void add(CategoryDto categoryDto);
        public void change(CategoryDto categoryDto);
        public void deleteCategory(long categoryId);


        these methode are not necessary for this project
    */
      public CategoryDto find(long categoryId);
      public List<CategoryDto> list();
}
