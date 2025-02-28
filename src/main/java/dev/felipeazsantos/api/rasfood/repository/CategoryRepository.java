package dev.felipeazsantos.api.rasfood.repository;

import dev.felipeazsantos.api.rasfood.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
