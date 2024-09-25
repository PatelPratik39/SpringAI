import React, { useState } from "react";

const Recipegenerator = () => {
  const [prompt, setPrompt] = useState();
  const [ingredients, setIngredients] = useState("");
  const [cuisine, setCuisine] = useState("any");
  const [dietaryRestrictions, setDietaryRestrictions] = useState("");
  const [recipe, setRecipe] = useState("");

  const createRecipe = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/generate-recipe?ingredients=${ingredients}&dietaryRestrictions=${dietaryRestrictions}&cuisine=${cuisine}`
      );
      const data = await response.text();
      console.log(data);
      setRecipe(data);
      setPrompt("");
    } catch (error) {
      console.error("Error Generating Recipe : ", error);
    }
  };

  return (
    <>
      <div>
        <h2>Recipe Generator</h2>
        <input
          type="text"
          value={ingredients}
          onChange={(e) => setIngredients(e.target.value)}
          placeholder="Enter your Ingredients ... "
        />
        <input
          type="text"
          value={cuisine}
          onChange={(e) => setCuisine(e.target.value)}
          placeholder="Enter your cuisine ... "
        />
        <input
          type="text"
          value={dietaryRestrictions}
          onChange={(e) => setDietaryRestrictions(e.target.value)}
          placeholder="Enter your Ingredients ... "
        />
        <button onClick={createRecipe}>Find your Recipe</button>

        <div className="output">
          <pre className="recipe-text">{recipe}</pre>
        </div>
      </div>
    </>
  );
};

export default Recipegenerator;
