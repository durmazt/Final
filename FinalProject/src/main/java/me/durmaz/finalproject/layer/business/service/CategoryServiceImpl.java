package me.durmaz.finalproject.layer.business.service;

import me.durmaz.finalproject.layer.business.dto.CategoryDto;
import me.durmaz.finalproject.layer.data.entity.Category;
import me.durmaz.finalproject.layer.data.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDto find(long categoryId) {
        Optional<Category> optional=categoryRepository.findById(categoryId);
        if(optional.isPresent()){
            return toDto(optional.get());
        }

        return null;
    }

    @Override
    public List<CategoryDto> list() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category category:categoryRepository.findAll())
        {
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    private Category toEntity(CategoryDto categoryDto) {
        Category category=new Category();
            category.setCategoryId(categoryDto.getCategoryId());
            category.setCategoryName(categoryDto.getCategoryName());

            return category;
    }
    private CategoryDto toDto(Category category) {
        CategoryDto categoryDto=new CategoryDto();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());

            return categoryDto;
    }
}
