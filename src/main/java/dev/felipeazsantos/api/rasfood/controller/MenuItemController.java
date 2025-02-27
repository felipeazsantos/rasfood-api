package dev.felipeazsantos.api.rasfood.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<MenuItem>> findAll() {
        return ResponseEntity.ok(menuItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(menuItemService.findById(id));
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
