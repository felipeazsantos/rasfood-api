package dev.felipeazsantos.api.rasfood.repository;

import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("SELECT new dev.felipeazsantos.api.rasfood.dto.MenuItemDto(mi.name, mi.description, mi.category.name, mi.price) FROM MenuItem mi " +
            " WHERE mi.name LIKE %:name% AND mi.available = true")
    List<MenuItemDto> findAllByName(String name);

    @Query(value = "SELECT * FROM menu_item mi where mi.category_id = ?1 and mi.available = true", nativeQuery = true)
    List<MenuItem> findAllByCategory(Long categoryId);
}
