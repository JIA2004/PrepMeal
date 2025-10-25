package com.mealprep.meal_planner_api.DTO;

import java.math.BigDecimal;

public record ShoppingListItemDTO(
    String name,
    BigDecimal totalQuantity,
    String unit
) {}