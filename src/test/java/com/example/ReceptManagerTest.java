package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class ReceptManagerTest {

    @Test
    public void testLäggTillRecept() {
        ReceptManager<Recept> manager = new ReceptManager<>();
        Recept recept = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        manager.läggTillRecept(recept);
        assertEquals(1, manager.visaAllaRecept().size());
    }

    @Test
    public void testLäggTillSammaReceptIFile() {
        ReceptManager<Recept> manager = new ReceptManager<>();
        Recept recept = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        manager.sparaReceptTillFil("recept.txt");
        manager.läggTillRecept(recept); // Försök lägga till samma recept igen
        assertEquals(1, manager.visaAllaRecept().size(), "Recept ska inte läggas till två gånger.");
    }

    @Test
    public void testTaBortRecept() {
        ReceptManager<Recept> manager = new ReceptManager<>();
        Recept recept = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        manager.läggTillRecept(recept);
        manager.taBortRecept("Pannkakor");
        assertEquals(0, manager.visaAllaRecept().size());
    }

    @Test
    public void testVisaAllaRecept() {
        ReceptManager<Recept> manager = new ReceptManager<>();
        Recept recept1 = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        Recept recept2 = new Recept("Våfflor", Arrays.asList("Mjöl", "Mjölk", "Smör"), "Grädda tills gyllenbrun.");
        manager.läggTillRecept(recept1);
        manager.läggTillRecept(recept2);
        assertEquals(2, manager.visaAllaRecept().size());
    }
}
