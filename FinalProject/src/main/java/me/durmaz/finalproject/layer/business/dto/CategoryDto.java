package me.durmaz.finalproject.layer.business.dto;

public class CategoryDto {

    private long categoryId;
    private String categoryName;

    public CategoryDto() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
