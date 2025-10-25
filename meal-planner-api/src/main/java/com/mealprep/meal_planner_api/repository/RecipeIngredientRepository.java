package com.mealprep.meal_planner_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.mealprep.meal_planner_api.DTO.ShoppingListItemDTO; // Este import es para el tipo de retorno
import com.mealprep.meal_planner_api.entity.RecipeIngredient;
import java.util.List;
import java.math.BigDecimal; // Asegúrate de que tu DTO usa BigDecimal

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

    // Tienes que usar el nombre completo de la clase DENTRO del string
    @Query("SELECT new com.mealprep.meal_planner_api.DTO.ShoppingListItemDTO(ri.ingredientMaster.name, SUM(ri.normalizedQuantity), ri.normalizedUnit) " +
            "FROM RecipeIngredient ri " +
            "WHERE ri.recipe.recipeId IN :recipeIds " +
            "GROUP BY ri.ingredientMaster.name, ri.normalizedUnit")
    List<ShoppingListItemDTO> getShoppingList(@Param("recipeIds") List<Integer> recipeIds);
}