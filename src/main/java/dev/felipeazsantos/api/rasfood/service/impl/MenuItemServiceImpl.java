package dev.felipeazsantos.api.rasfood.service.impl;

import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.exception.NotFoundException;
import dev.felipeazsantos.api.rasfood.repository.MenuItemRepository;
import dev.felipeazsantos.api.rasfood.repository.projection.MenuItemProjection;
import dev.felipeazsantos.api.rasfood.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public Page<MenuItem> findAll(Pageable pageable) {
        return menuItemRepository.findAll(pageable);
    }

    @Override
    public Page<MenuItemProjection> findAllByCategory(Long categoryId, Pageable pageable) {
        return menuItemRepository.findAllByCategory(categoryId, pageable);
    }

    @Override
    public Page<MenuItemDto> findAllByName(String name, Pageable pageable) {
        return menuItemRepository.findAllByName(name, pageable);
    }

    @Override
    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElseThrow(() -> new NotFoundException("MenuItem not founded"));
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void delete(Long id) {
        MenuItem menuItem = findById(id);
        menuItemRepository.delete(menuItem);
    }
}
