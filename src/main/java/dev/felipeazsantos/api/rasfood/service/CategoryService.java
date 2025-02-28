package dev.felipeazsantos.api.rasfood.service;

import dev.felipeazsantos.api.rasfood.entity.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
}
