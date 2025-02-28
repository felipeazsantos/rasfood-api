package dev.felipeazsantos.api.rasfood.repository.projection;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface MenuItemProjection {

    String getName();
    String getDescription();
    String getCategoryName();
    BigDecimal getPrice();
}
