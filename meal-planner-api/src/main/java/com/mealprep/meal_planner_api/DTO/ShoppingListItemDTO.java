package com.mealprep.meal_planner_api.DTO;

// Este "record" es un POJO inmutable. Perfecto para un DTO.
public record ShoppingListItemDTO(
    String name,
    Double totalQuantity,
    String unit
) {}