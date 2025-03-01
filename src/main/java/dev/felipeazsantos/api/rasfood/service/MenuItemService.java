package dev.felipeazsantos.api.rasfood.service;

import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.repository.projection.MenuItemProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MenuItemService {
    Page<MenuItem> findAll(Pageable pageable);
    Page<MenuItemProjection> findAllByCategory(Long categoryId, Pageable pageable);
    Page<MenuItemDto> findAllByName(String name, Pageable pageable);
    MenuItem findById(Long id);
    MenuItem save(MenuItem menuItem);
    void delete(Long id);
}
