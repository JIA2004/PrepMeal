package com.mealprep.meal_planner_api.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeIngredientId;
    
    @ManyToOne // Un ingrediente de receta pertenece a UNA receta
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    
    @ManyToOne // Un ingrediente de receta apunta a UN ingrediente maestro
    @JoinColumn(name = "ingredient_id")
    private IngredientsMaster ingredientMaster;
    
    private String displayText;
    private BigDecimal normalizedQuantity;
    private String normalizedUnit;
    
    // Constructores, Getters y Setters
}