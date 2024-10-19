package com.example;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReceptManager<Recept> receptManager = new ReceptManager<>();

        boolean körProgram = true;

        while (körProgram) {
            System.out.println("Välj ett alternativ:");
            System.out.println("1. Lägg till ett nytt recept");
            System.out.println("2. Visa alla recept");
            System.out.println("3. Ta bort ett recept");
            System.out.println("4. Spara recept till fil");
            System.out.println("5. Läs recept från fil");
            System.out.println("6. Ta bort recept från fil");
            System.out.println("7. (Hjälp) Visa exempel");
            System.out.println("8. Avsluta");

            int val = scanner.nextInt();
            scanner.nextLine(); // Rensa inmatningsbufferten efter nextInt()

            // Utskrift av vilket val som gjorts
            System.out.println("Du valde: " + val);

            switch (val) {
                case 1:
                    läggTillNyttRecept(scanner, receptManager);
                    break;
                case 2:
                    receptManager.visaAllaRecept();
                    break;
                case 3:
                    System.out.println("Ange titeln på receptet du vill ta bort:");
                    String titelAttTaBort = scanner.nextLine();
                    receptManager.taBortRecept(titelAttTaBort);
                    break;
                case 4:
                    receptManager.sparaReceptTillFil("recept.txt");
                    break;
                case 5:
                    receptManager.läsReceptFrånFil("recept.txt");
                    break;
                case 6:
                    System.out.println("Ange titeln på receptet du vill ta bort från filen:");
                    String receptAttTaBortFrånFil = scanner.nextLine();
                    receptManager.taBortReceptFrånFil("recept.txt", receptAttTaBortFrånFil);
                    break;
                case 7:
                    visaExempelRecept();
                    break;
                case 8:
                    körProgram = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }

        scanner.close();
    }

    public static void läggTillNyttRecept(Scanner scanner, ReceptManager<Recept> receptManager) {
        System.out.println("Ange receptets titel:");
        String titel = scanner.nextLine();

        List<String> ingredienser = new ArrayList<>();
        boolean läggTillFlerIngredienser = true;

        while (läggTillFlerIngredienser) {
            System.out.println("Ange en ingrediens (eller skriv 'klar' för att avsluta):");
            String ingrediens = scanner.nextLine();

            if (ingrediens.equalsIgnoreCase("klar")) {
                läggTillFlerIngredienser = false;
            } else {
                ingredienser.add(ingrediens);
            }
        }

        System.out.println("Ange instruktioner för receptet:");
        String instruktioner = scanner.nextLine();

        Recept recept = new Recept(titel, ingredienser, instruktioner);
        receptManager.läggTillRecept(recept);
    }

    // Ny metod för att visa exempelmaträtter per kategori
    public static void visaExempelRecept() {
        System.out.println("Exempel på maträtter för Frukost:");
        System.out.println("1. Ägg och bacon");
        System.out.println("2. Pannkakor med sylt");
        System.out.println("3. Smoothie med bär");

        System.out.println("\nExempel på maträtter för Lunch:");
        System.out.println("1. Kycklingsallad");
        System.out.println("2. Spaghetti med köttfärssås");
        System.out.println("3. Falafelwrap");

        System.out.println("\nExempel på maträtter för Middag:");
        System.out.println("1. Grilled lax med sparris");
        System.out.println("2. Biff med potatisgratäng");
        System.out.println("3. Tacos med grönsaker");
        System.out.println();
    }
}