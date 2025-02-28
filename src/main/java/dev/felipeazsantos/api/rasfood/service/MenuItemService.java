package dev.felipeazsantos.api.rasfood.service;

import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.repository.projection.MenuItemProjection;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MenuItemService {
    Page<MenuItem> findAll(Pageable pageable);
    List<MenuItemProjection> findAllByCategory(Long categoryId);
    List<MenuItemDto> findAllByName(String name);
    MenuItem findById(Long id);
    MenuItem save(MenuItem menuItem);
    void delete(Long id);
}
