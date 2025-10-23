package com.mealprep.meal_planner_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    
    private String name;
    private String instructions;
    
    // Ojo: Si quieres la lista de ingredientes aquí, 
    // añade @OneToMany. Para el MVP, podemos mantenerlo simple.
    
    // Constructores, Getters y Setters
}
