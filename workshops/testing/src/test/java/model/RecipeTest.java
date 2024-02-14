package model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class RecipeTest {

    private Recipe recipe;

    private void setupStage1 () {

        recipe = new Recipe("Rice soup", new ArrayList<Ingredient>());

    }

    private void setupStage2 () {

        var ingredients = new ArrayList<Ingredient>();

        ingredients.add(new Ingredient("Onion", 300));
        ingredients.add(new Ingredient("Garlic", 100));
        ingredients.add(new Ingredient("Rice", 500));

        recipe = new Recipe("Rice soup", ingredients);

    }

    @Test
    public void testCreateNew() {

        setupStage1();

        assertNotNull(recipe);
        assertNotNull(recipe.getName());
        assertNotNull(recipe.getIngredients());

    }

    @Test
    public void testAddIngredientToEmptyRecipe() {

        setupStage1();
        
        recipe.addIngredient(new Ingredient("Salt", 12));
        assertEquals(1, recipe.getIngredients().size());

        var salt = recipe.getIngredient("Salt");
        assertEquals("Salt", salt.getName());
        assertEquals(12, salt.getWeight(), 0.1);

    }

    @Test
    public void testAddIngredient() {

        setupStage2();

        recipe.addIngredient(new Ingredient("Pepper", 6));
        assertEquals(4, recipe.getIngredients().size());

        var pepper = recipe.getIngredient("Pepper");
        assertEquals("Pepper", pepper.getName());
        assertEquals(6, pepper.getWeight(), 0.1);

    }

    @Test
    public void testAddIngredientAlreadyIn() {

        setupStage2();

        recipe.addIngredient(new Ingredient("Garlic", 21));
        assertEquals(3, recipe.getIngredients().size());

        var garlic = recipe.getIngredient("Garlic");

        assertEquals("Garlic", garlic.getName());
        assertEquals(121, garlic.getWeight(), 0.1);

    }

    @Test
    public void testRemoveIngredient() {

        setupStage2();

        recipe.removeIngredient("Garlic");
        assertEquals(2, recipe.getIngredients().size());

    }

}
