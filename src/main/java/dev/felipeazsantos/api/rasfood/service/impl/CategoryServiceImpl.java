package dev.felipeazsantos.api.rasfood.service.impl;

import dev.felipeazsantos.api.rasfood.entity.Category;
import dev.felipeazsantos.api.rasfood.exception.NotFoundException;
import dev.felipeazsantos.api.rasfood.repository.CategoryRepository;
import dev.felipeazsantos.api.rasfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
