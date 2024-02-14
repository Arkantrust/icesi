package model;

import org.junit.Test;
import static org.junit.Assert.*;

import exception.NegativeNumberException;

public class IngredientTest {

    private Ingredient ingredient;

    private void setupStage1() {

        ingredient = new Ingredient("Tomato", 245);

    }

    @Test
    public void testCreateNew() {

        setupStage1();
        assertEquals("Tomato", ingredient.getName());
        assertEquals(245, ingredient.getWeight(), 0.1);

    }

    @Test
    public void testAddWeight() {

        setupStage1();
        ingredient.addWeight(54);
        assertEquals(299, ingredient.getWeight(), 0.1);

    }

    @Test
    public void testAddNegativeWeight() {

        setupStage1();
        assertThrows(NegativeNumberException.class, () -> ingredient.addWeight(-100));
        assertEquals(245, ingredient.getWeight(), 0.1);

    }

    @Test
    public void testRemoveWeight() {

        setupStage1();
        ingredient.removeWeight(45);
        assertEquals(200, ingredient.getWeight(), 0.1);

    }

    @Test
    public void testRemoveNegativeWeight() {

        setupStage1();
        assertThrows(NegativeNumberException.class, () -> ingredient.removeWeight(-100));
        assertEquals(245, ingredient.getWeight(), 0.1);

    }

}