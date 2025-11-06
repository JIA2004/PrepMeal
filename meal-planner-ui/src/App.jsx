import React, { useState } from 'react';
import './index.css'; // Importamos nuestros estilos
import RecipeList from './components/RecipeList';
import WeeklyPlanner from './components/WeeklyPlanner';
import ShoppingList from './components/ShoppingList';

function App() {
  // Este es el estado principal: las recetas que el usuario añade al plan
  const [plannerRecipes, setPlannerRecipes] = useState([]);

  // Función para AÑADIR una receta al plan
  // Esta función se la pasaremos como prop a RecipeList
  const addRecipeToPlanner = (recipe) => {
    // Añadimos la receta a la lista
    setPlannerRecipes([...plannerRecipes, recipe]);
  };

  const removeRecipeFromPlanner = (recipeIndexToRemove) => {
    setPlannerRecipes(
      plannerRecipes.filter((_, index) => index !== recipeIndexToRemove)
    );
  };

  return (
    <div className="app-container">
      <aside className="sidebar">
        {/* ... (código de RecipeList) ... */}
        <RecipeList onRecipeSelect={addRecipeToPlanner} />
      </aside>

      <main className="main-content">
        <h2>Mi Plan Semanal (Fase 0.5)</h2>
        <p>(Haz clic en una receta de la izquierda para añadirla)</p>
        <p>(Haz clic en una receta del plan para eliminarla)</p>

        {/* --- LÍNEA CLAVE 2: La función debe pasarse como prop --- */}
        <WeeklyPlanner 
            recipes={plannerRecipes} 
            onRecipeRemove={removeRecipeFromPlanner} 
        />
        
        <hr />
        
        <h2>Lista de Supermercado</h2>
        <ShoppingList recipesInPlan={plannerRecipes} />
      </main>
    </div>
  );
}

export default App;