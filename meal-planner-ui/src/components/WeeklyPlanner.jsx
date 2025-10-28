import React from 'react';

// Este componente solo MUESTRA las recetas que están en el estado del padre
function WeeklyPlanner({ recipes, onRecipeRemove }) {
    if (recipes.length === 0) {
        return <p>Aún no has añadido recetas a tu plan.</p>;
    }

    return (
        <div>
        {/* --- ACTUALIZA EL MAP --- */}
        {recipes.map((recipe, index) => (
            <div 
            key={index} // Usar el index aquí es seguro porque la lista es simple
            className="planner-item"
            title="Haz clic para eliminar" // Añade un tooltip
            onClick={() => onRecipeRemove(index)} // Llama a la función del padre
            >
            {recipe.name} <span>(X)</span> {/* Añade un indicador visual (X) */}
            </div>
        ))}
        {/* --- FIN DE LA ACTUALIZACIÓN --- */}
        </div>
    );
}

export default WeeklyPlanner;