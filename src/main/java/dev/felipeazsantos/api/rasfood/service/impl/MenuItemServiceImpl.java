package dev.felipeazsantos.api.rasfood.service.impl;

import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.exception.NotFoundException;
import dev.felipeazsantos.api.rasfood.repository.MenuItemRepository;
import dev.felipeazsantos.api.rasfood.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
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
