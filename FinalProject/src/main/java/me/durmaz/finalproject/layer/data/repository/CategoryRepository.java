package me.durmaz.finalproject.layer.data.repository;

import me.durmaz.finalproject.layer.data.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
