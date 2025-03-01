package dev.felipeazsantos.api.rasfood.repository.specification;

import dev.felipeazsantos.api.rasfood.entity.MenuItem;
import org.springframework.data.jpa.domain.Specification;

public class MenuItemSpec {
    public static Specification<MenuItem> name(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .like(root.get("name"), "%" + name + "%");
    }

    public static Specification<MenuItem> category(Long category) {
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("category"), category);
    }

    public static Specification<MenuItem> available(Boolean available) {
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("available"), available);
    }
}
