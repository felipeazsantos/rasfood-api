package dev.felipeazsantos.api.rasfood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItemDto {

    private Long id;

    private String name;

    private String description;

    private String categoryName;

    private BigDecimal price;

    public MenuItemDto(String name, String description, String categoryName, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.categoryName = categoryName;
        this.price = price;
    }

    public MenuItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
