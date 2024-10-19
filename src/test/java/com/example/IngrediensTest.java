package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngrediensTest {

    @Test
    public void testSkapaIngrediens() {
        Ingrediens ingrediens = new Ingrediens("Mjöl", "2 dl");
        assertEquals("Mjöl", ingrediens.getIngrediensNamn());
        assertEquals("2 dl", ingrediens.getIngrediensMängd());
    }

    @Test
    public void testIngrediensSetters() {
        Ingrediens ingrediens = new Ingrediens("Mjöl", "2 dl");
        ingrediens.setIngrediensNamn("Socker");
        ingrediens.setIngrediensMängd("3 dl");
        assertEquals("Socker", ingrediens.getIngrediensNamn());
        assertEquals("3 dl", ingrediens.getIngrediensMängd());
    }

    @Test
    public void testIngrediensToString() {
        Ingrediens ingrediens = new Ingrediens("Mjöl", "2 dl");
        assertEquals("Mjöl: 2 dl", ingrediens.toString());
    }
}
