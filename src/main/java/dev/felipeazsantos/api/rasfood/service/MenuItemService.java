package dev.felipeazsantos.api.rasfood.service;

import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import java.util.List;


public interface MenuItemService {
    List<MenuItem> findAll();
    List<MenuItem> findAllByCategory(Long categoryId);
    MenuItem findById(Long id);
    MenuItem save(MenuItem menuItem);
    void delete(Long id);
}
