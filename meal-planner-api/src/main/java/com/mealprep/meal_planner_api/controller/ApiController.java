package com.mealprep.meal_planner_api.controller;

import org.springframework.web.bind.annotation.*;

import com.mealprep.meal_planner_api.DTO.ShoppingListItemDTO;
import com.mealprep.meal_planner_api.entity.Recipe;
import com.mealprep.meal_planner_api.service.ShoppingListService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1") // Prefijo para nuestra API
public class ApiController {

    private final ShoppingListService service;

    public ApiController(ShoppingListService service) {
        this.service = service;
    }

    // Este es el endpoint para el planificador
    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return service.getAllRecipes();
    }

    // ¡ESTE ES EL CORAZÓN DEL MVP!
    // El front-end nos enviará los IDs de las recetas seleccionadas
    @PostMapping("/shopping-list")
    public List<ShoppingListItemDTO> getShoppingList(@RequestBody List<Integer> recipeIds) {
        // Ejemplo de body que esperamos: [1, 2]
        return service.generateList(recipeIds);
    }
}