package dev.felipeazsantos.api.rasfood.repository;

import dev.felipeazsantos.api.rasfood.dto.MenuItemDto;
import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import dev.felipeazsantos.api.rasfood.repository.projection.MenuItemProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>, JpaSpecificationExecutor<MenuItem> {

    @Query("SELECT new dev.felipeazsantos.api.rasfood.dto.MenuItemDto(mi.name, mi.description, mi.category.name, mi.price) FROM MenuItem mi " +
            " WHERE mi.name LIKE %:name% AND mi.available = true")
    Page<MenuItemDto> findAllByName(String name, Pageable pageable);

    @Query(value = "SELECT  mi.name as name, " +
            " mi.description as description, " +
            " c.name as categoryName, " +
            " mi.price as price " +
            " FROM menu_item mi " +
            " JOIN category c ON c.id = mi.category_id " +
            " WHERE mi.category_id = ?1  " +
            " AND mi.available = true",
            nativeQuery = true,
            countQuery = "SELECT count(*) FROM menu_item"
    )
    Page<MenuItemProjection> findAllByCategory(Long categoryId, Pageable pageable);
}
