import React, { useState } from 'react';

function ShoppingList({ recipesInPlan }) {
    const [list, setList] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(false);

    const handleGenerateList = async () => {    
        setIsLoading(true);
        setError(null);
        setList([]);

        // 1. Extraer los IDs de las recetas en el plan
        const recipeIds = recipesInPlan.map(recipe => recipe.recipeId);

        // 2. Validar que haya recetas
        if (recipeIds.length === 0) {
        setError('Añade al menos una receta al plan para generar la lista.');
        setIsLoading(false);
        return;
        }

        try {
        // 3. Llamar a tu API POST (el corazón del MVP)
        const response = await fetch('http://localhost:8080/api/v1/shopping-list', {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json',
            },
            body: JSON.stringify(recipeIds),
        });

        if (!response.ok) {
            throw new Error('Error al generar la lista');
        }

        const data = await response.json();
        setList(data);

        } catch (err) {
        setError(err.message);
        } finally {
        setIsLoading(false);
        }
    };

    return (
        <div className="shopping-list">
        <button 
            className="generate-button" 
            onClick={handleGenerateList} 
            disabled={isLoading}
        >
            {isLoading ? 'Generando...' : 'Generar Lista de Supermercado'}
        </button>

        {error && <p style={{ color: 'red' }}>{error}</p>}

        {list.length > 0 && (
            <ul>
            {list.map(item => (
                <li key={item.name}>
                {item.name}: {item.totalQuantity} {item.unit}
                </li>
            ))}
            </ul>
        )}
        </div>
    );
}

export default ShoppingList;