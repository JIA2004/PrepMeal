import React, { useState, useEffect } from 'react';

function RecipeList({ onRecipeSelect }) {
  console.log("Renderizando RecipeList..."); // <--- CONSOLE LOG 1
  const [recipes, setRecipes] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchRecipes = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/v1/recipes');
        if (!response.ok) {
          throw new Error('Error al cargar recetas');
        }
        const data = await response.json();
        console.log("Datos recibidos:", data); // <--- CONSOLE LOG 2
        setRecipes(data);
      } catch (err) {
        setError(err.message);
        console.error("Error en fetchRecipes:", err); // <-- Añade esto también
      }
    };

    fetchRecipes();
  }, []); 

  if (error) {
    // Mostremos el error en la UI también, no solo en consola
    return <div>Error al cargar recetas: {error}</div>; 
  }

  // Añadamos un mensaje si recipes está vacío *después* de intentar cargar
  if (recipes.length === 0 && !error) {
       return <div>Cargando recetas o no hay recetas disponibles...</div>;
  }


  return (
    <div>
      {recipes.map(recipe => (
        <div 
          key={recipe.recipeId} 
          className="recipe-item"
          onClick={() => onRecipeSelect(recipe)}
        >
          {recipe.name}
        </div>
      ))}
    </div>
  );
}

export default RecipeList;