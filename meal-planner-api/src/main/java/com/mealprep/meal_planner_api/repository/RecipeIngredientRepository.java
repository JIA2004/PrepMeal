package com.mealprep.meal_planner_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mealprep.meal_planner_api.DTO.ShoppingListItemDTO;
import com.mealprep.meal_planner_api.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

    // Este es tu query SQL, pero escrito en JPQL (Java Persistence Query Language)
    @Query("SELECT new com.tuproyecto.dto.ShoppingListItemDTO(ri.ingredientMaster.name, SUM(ri.normalizedQuantity), ri.normalizedUnit) " +
            "FROM RecipeIngredient ri " +
            "WHERE ri.recipe.recipeId IN :recipeIds " + // :recipeIds es un parámetro
            "GROUP BY ri.ingredientMaster.name, ri.normalizedUnit")
    List<ShoppingListItemDTO> getShoppingList(@Param("recipeIds") List<Integer> recipeIds);
}