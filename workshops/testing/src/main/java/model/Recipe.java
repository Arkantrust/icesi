package model;

import java.util.List;

public class Recipe {

    private String name;

    private List<Ingredient> ingredients;

    public Recipe(String name, List<Ingredient> ingredients) {

        this.name = name;
        this.ingredients = ingredients;

    }

    /**
     * 
     * Returns the ingredient with the given name or null if it isn't found.
     * 
     * @param name The name of the ingredient being searched. e.g. "Garlic"
     * 
     */
    public Ingredient getIngredient(String name) {

        Ingredient target = null;

        for (int i = 0; i < ingredients.size() && target == null; i++) {

            Ingredient current = ingredients.get(i);

            if (current.getName().equals(name)) {

                target = current;

            }

        }

        return target;

    }

    /**
     * 
     * Adds a new ingredient to the recipe or increases the weight if it already
     * exists in the recipe.
     * 
     * @param ingredient The ingredient being added. e.g. new Ingredient("Garlic", 100)
     * 
     */
    public void addIngredient(Ingredient ingredient) {

        var possibleIngredient = getIngredient(ingredient.getName());

        if (possibleIngredient == null) {

            ingredients.add(ingredient);

        } else {

            possibleIngredient.addWeight(ingredient.getWeight());

        }

    }

    /**
     * 
     * Removes the ingredient with the given name from the recipe.
     * 
     * @param name The name of the ingredient being removed. e.g. "Garlic"
     * 
     */
    public void removeIngredient(String name) {

        Ingredient target = getIngredient(name);

        if (target != null) {

            ingredients.remove(target);

        }

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public List<Ingredient> getIngredients() {

        return ingredients;

    }

    public void setIngredients(List<Ingredient> ingredients) {

        this.ingredients = ingredients;

    }

}
