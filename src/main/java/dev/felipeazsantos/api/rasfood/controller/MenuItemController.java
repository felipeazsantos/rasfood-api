package dev.felipeazsantos.api.rasfood.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.repository.projection.MenuItemProjection;
import dev.felipeazsantos.api.rasfood.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<Page<MenuItem>> findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(menuItemService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(menuItemService.findById(id));
    }

    @GetMapping("/category/{id}/available")
    public ResponseEntity<Page<MenuItemProjection>> findAllByCategory(@PathVariable("id") Long categoryId, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(menuItemService.findAllByCategory(categoryId, pageable));
    }

    @GetMapping("/name/{name}/available")
    public ResponseEntity<Page<MenuItemDto>> findAllByName(@PathVariable("name") String name, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(menuItemService.findAllByName(name, pageable));
    }

    @PostMapping
    public ResponseEntity<MenuItem> create(@RequestBody MenuItem menuItem) {
        if (Objects.nonNull(menuItem.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItemService.save(menuItem));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MenuItem> update(@PathVariable("id") Long id, @RequestBody MenuItem menuItem) throws JsonMappingException {
        MenuItem menuItemFounded = menuItemService.findById(id);
        objectMapper.updateValue(menuItemFounded, menuItem);
        return ResponseEntity.ok(menuItemService.save(menuItemFounded));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        menuItemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
