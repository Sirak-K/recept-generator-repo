package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReceptManager<T> {
    private List<T> receptLista = new ArrayList<>();

    // Lägg till ett recept i listan med validering för dubbletter
    public void läggTillRecept(T recept) {
        Recept nyttRecept = (Recept) recept;

        // Kontrollera om receptet redan finns i listan (working memory)
        if (hittaRecept(nyttRecept.getReceptTitel()) != null) {
            System.out.println("Ett recept med namnet '" + nyttRecept.getReceptTitel() + "' finns redan i minnet.");
            return;
        }

        // Kontrollera om receptet redan finns i filen
        if (receptFinnsIFil(nyttRecept.getReceptTitel(), "recept.txt")) {
            System.out.println("Ett recept med namnet '" + nyttRecept.getReceptTitel() + "' finns redan i filen.");
            return;
        }

        // Om ingen dubblett hittas, lägg till receptet
        receptLista.add(recept);
        System.out.println("Receptet har lagts till.");
    }

    // Hitta ett recept baserat på titeln i listan (working memory)
    public T hittaRecept(String titel) {
        for (T ettRecept : receptLista) {
            if (((Recept) ettRecept).getReceptTitel().equalsIgnoreCase(titel)) {
                return ettRecept;
            }
        }
        return null;
    }

    // Kontrollera om ett recept finns i filen
    private boolean receptFinnsIFil(String titel, String filnamn) {
        try {
            List<String> rader = Files.readAllLines(Paths.get(filnamn), StandardCharsets.UTF_8);
            for (String rad : rader) {
                if (rad.contains(titel)) {
                    return true; // Om recepttitel hittas i filen
                }
            }
        } catch (IOException e) {
            System.out.println("Fel vid läsning från fil: " + e.getMessage());
        }
        return false;
    }

    // Visa alla recept i listan och returnera listan
    public List<T> visaAllaRecept() {
        if (receptLista.isEmpty()) {
            System.out.println("Inga recept finns tillgängliga.");
        } else {
            for (T ettRecept : receptLista) {
                System.out.println(ettRecept);
            }
        }
        return receptLista; // Returnera listan av recept
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

    // Ta bort ett recept från fil baserat på titeln
    public void taBortReceptFrånFil(String filnamn, String titel) {
        try {
            List<String> rader = Files.readAllLines(Paths.get(filnamn), StandardCharsets.UTF_8);
            List<String> uppdateradeRader = rader.stream()
                    .filter(rad -> !rad.contains(titel))
                    .collect(Collectors.toList());

            Files.write(Paths.get(filnamn), uppdateradeRader, StandardCharsets.UTF_8);
            System.out.println("Receptet har tagits bort från filen.");
        } catch (IOException e) {
            System.out.println("Fel vid borttagning av recept från fil: " + e.getMessage());
        }
    }

    // Filhantering: Läs recept från fil
    public void läsReceptFrånFil(String filnamn) {
        try {
            List<String> rader = Files.readAllLines(Paths.get(filnamn), StandardCharsets.UTF_8);
            for (String rad : rader) {
                System.out.println("Läst rad: " + rad);
            }
        } catch (IOException e) {
            System.out.println("Fel vid läsning från fil: " + e.getMessage());
        }
    }

    // Filhantering: Spara recept till fil
    public void sparaReceptTillFil(String filnamn) {
        StringBuilder data = new StringBuilder();
        for (T ettRecept : receptLista) {
            data.append(ettRecept.toString()).append("\n");
        }
        try {
            Files.write(Paths.get(filnamn), data.toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("Recept sparade till filen " + filnamn);
        } catch (IOException e) {
            System.out.println("Fel vid skrivning till fil: " + e.getMessage());
        }
    }

}
