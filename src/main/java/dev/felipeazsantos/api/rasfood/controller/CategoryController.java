package dev.felipeazsantos.api.rasfood.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.felipeazsantos.api.rasfood.entity.Category;
import dev.felipeazsantos.api.rasfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        if (Objects.nonNull(category.getId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, Category category) throws JsonMappingException {
        Category categoryFounded = categoryService.findById(id);
        objectMapper.updateValue(categoryFounded, category);
        return ResponseEntity.ok(categoryService.save(categoryFounded));
    }


}
