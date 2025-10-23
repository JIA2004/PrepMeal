package com.mealprep.meal_planner_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mealprep.meal_planner_api.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    // Spring nos da findAll(), findById(), etc. gratis.
    // Esto nos servirá para el endpoint "GET /api/recipes"
}