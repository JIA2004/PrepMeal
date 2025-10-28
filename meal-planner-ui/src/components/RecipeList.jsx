import React, { useState, useEffect } from 'react';

// Este componente recibe 'onRecipeSelect' como prop, que es la función
// 'addRecipeToPlanner' que vive en App.jsx
function RecipeList({ onRecipeSelect }) {
    const [recipes, setRecipes] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        // Función para llamar a tu API de Spring Boot
        const fetchRecipes = async () => {
        try {
            // Llama a tu endpoint GET
            const response = await fetch('http://localhost:8080/api/v1/recipes');
            if (!response.ok) {
            throw new Error('Error al cargar recetas');
            }
            const data = await response.json();
            setRecipes(data);
        } catch (err) {
            setError(err.message);
        }
        };

        fetchRecipes();
    }, []); // El array vacío [] significa que se ejecuta 1 sola vez

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
        {recipes.map(recipe => (
            <div 
            key={recipe.recipeId} 
            className="recipe-item"
            // Al hacer clic, llamamos a la función del padre (App.jsx)
            onClick={() => onRecipeSelect(recipe)}
            >
            {recipe.name}
            </div>
        ))}
        </div>
    );
}

export default RecipeList;