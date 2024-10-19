package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class ReceptTest {

    @Test
    public void testSkapaRecept() {
        Recept recept = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        assertEquals("Pannkakor", recept.getReceptTitel());
        assertEquals(3, recept.getIngredienser().size());
        assertEquals("Blanda och stek.", recept.getInstruktioner());
    }

    @Test
    public void testReceptSetters() {
        Recept recept = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        recept.setReceptTitel("Våfflor");
        recept.setIngredienser(Arrays.asList("Mjöl", "Mjölk", "Smör"));
        recept.setInstruktioner("Grädda tills gyllenbrun.");
        assertEquals("Våfflor", recept.getReceptTitel());
        assertEquals(3, recept.getIngredienser().size());
        assertEquals("Grädda tills gyllenbrun.", recept.getInstruktioner());
    }

    @Test
    public void testReceptToString() {
        Recept recept = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        String expected = "Recept{titel='Pannkakor', ingredienser=[Ägg, Mjöl, Mjölk], instruktioner='Blanda och stek.'}";
        assertEquals(expected, recept.toString());
    }
}
