package com.mealprep.meal_planner_api.service;

import org.springframework.stereotype.Service;

import com.mealprep.meal_planner_api.DTO.ShoppingListItemDTO;
import com.mealprep.meal_planner_api.entity.Recipe;
import com.mealprep.meal_planner_api.repository.RecipeIngredientRepository;
import com.mealprep.meal_planner_api.repository.RecipeRepository;

import java.util.List;

@Service
public class ShoppingListService {

    private final RecipeIngredientRepository recipeIngredientRepo;
    private final RecipeRepository recipeRepo;

    // Inyección de dependencias
    public ShoppingListService(RecipeIngredientRepository repo, RecipeRepository recipeRepo) {
        this.recipeIngredientRepo = repo;
        this.recipeRepo = recipeRepo;
    }

    // Endpoint 1: Generar la lista de súper
    public List<ShoppingListItemDTO> generateList(List<Integer> recipeIds) {
        // La lógica compleja ya la hizo la BD/JPA.
        return recipeIngredientRepo.getShoppingList(recipeIds);
    }

    // Endpoint 2: Traer todas las recetas para el planificador
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }
}