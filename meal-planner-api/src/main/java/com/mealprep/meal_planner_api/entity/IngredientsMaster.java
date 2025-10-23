package com.mealprep.meal_planner_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients_master")
public class IngredientsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredientId;
    
    private String name;
    private String baseUnit;
    
    // Constructores, Getters y Setters (o usa @Data de Lombok)
}