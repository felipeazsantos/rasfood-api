package dev.felipeazsantos.api.rasfood.service;

import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.repository.projection.MenuItemProjection;

import java.util.List;


public interface MenuItemService {
    List<MenuItem> findAll();
    List<MenuItemProjection> findAllByCategory(Long categoryId);
    List<MenuItemDto> findAllByName(String name);
    MenuItem findById(Long id);
    MenuItem save(MenuItem menuItem);
    void delete(Long id);
}
