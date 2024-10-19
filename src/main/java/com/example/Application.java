package com.example;

import java.util.List;
import java.util.Arrays; // Lägg till denna import för Arrays.asList()

public class Application {
    public static void main(String[] args) {
        ReceptManager<Recept> receptManager = new ReceptManager<>();

        // Skapa och lägg till recept (ändrat till Arrays.asList för att skapa en
        // List<String>)
        Recept recept1 = new Recept("Pannkakor", Arrays.asList("Ägg", "Mjöl", "Mjölk"), "Blanda och stek.");
        receptManager.läggTillRecept(recept1);

        // Visa alla recept
        receptManager.visaAllaRecept();

        // Ta bort recept
        receptManager.taBortRecept("Pannkakor");

        // Spara till fil
        receptManager.sparaReceptTillFil("recept.txt");

        // Läs från fil
        receptManager.läsReceptFrånFil("recept.txt");
    }
}
