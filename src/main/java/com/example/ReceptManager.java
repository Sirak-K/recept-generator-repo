package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReceptManager<T> {
    private List<T> receptLista = new ArrayList<>();

    // Lägg till ett recept i listan med validering
    // @TODO: Lägg till validering för att säkerställa att receptet inte är null

    public void läggTillRecept(T recept) {
        if (recept != null && ((Recept) recept).getReceptTitel() != null
                && !((Recept) recept).getReceptTitel().isEmpty()) {
            receptLista.add(recept);
            System.out.println("Receptet har lagts till.");
        } else {
            System.out.println("Ogiltigt recept: Titeln kan inte vara tom.");
        }
    }

    // @TODO: Skapa en bättre metod för att sortera recepten i listan
    // * kanske efter kategori eller alfabetisk ordning
    // Visa alla recept i listan
    public void visaAllaRecept() {
        if (receptLista.isEmpty()) {
            System.out.println("Inga recept finns tillgängliga.");
        } else {
            for (T ettRecept : receptLista) {
                System.out.println(ettRecept);
            }
        }
    }

    // Ta bort ett recept baserat på titeln
    public boolean taBortRecept(String titel) {
        T receptAttTaBort = hittaRecept(titel);
        if (receptAttTaBort != null) {
            receptLista.remove(receptAttTaBort);
            System.out.println("Recept " + titel + " har tagits bort.");
            return true;
        } else {
            System.out.println("Receptet kunde inte hittas.");
            return false;
        }
    }

    // Hitta ett recept baserat på titeln
    public T hittaRecept(String titel) {
        for (T ettRecept : receptLista) {
            if (((Recept) ettRecept).getReceptTitel().equalsIgnoreCase(titel)) {
                return ettRecept;
            }
        }
        return null;
    }

    // Filhantering: Spara recept till fil
    public void sparaReceptTillFil(String filnamn) {
        // @TODO: Implementera bättre felhantering här för att fånga IOExceptions
        StringBuilder data = new StringBuilder();
        for (T ettRecept : receptLista) {
            data.append(ettRecept.toString()).append("\n");
        }
        try {
            Files.write(Paths.get(filnamn), data.toString().getBytes());
            System.out.println("Recept sparade till filen " + filnamn);
        } catch (IOException e) {
            System.out.println("Fel vid skrivning till fil: " + e.getMessage());
        }
    }

    // Filhantering: Läs recept från fil
    public void läsReceptFrånFil(String filnamn) {
        try {
            List<String> rader = Files.readAllLines(Paths.get(filnamn));
            for (String rad : rader) {
                // Här kan du implementera logik för att omvandla varje rad till ett
                // Recept-objekt
                System.out.println("Läst rad: " + rad);
            }
        } catch (IOException e) {
            System.out.println("Fel vid läsning från fil: " + e.getMessage());
        }
    }
}
