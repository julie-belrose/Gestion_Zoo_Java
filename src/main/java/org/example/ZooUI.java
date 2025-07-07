package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooUI {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Animal> ANIMALS = new ArrayList<>();
    private static final List<Enclosure> ENCLOSURES = new ArrayList<>();

    private static void showMenu() {
        System.out.println("\n--- ZOO MENU ---");
        System.out.println("1. Add an animal");
        System.out.println("2. Add an enclosure");
        System.out.println("3. Add an animal to an enclosure");
        System.out.println("4. Display animals by enclosure");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
    }

    private static int readInt() {
        int n = SCANNER.nextInt();
        SCANNER.nextLine();
        return n;
    }

    private static void preloadData() {
        // --- animals ---
        Animal leo = new Leo("Leo", 5);
        Animal nala = new Leo("Nala", 4);
        Animal ella = new Elephant("Ella", 10, 3200);

        ANIMALS.add(leo);
        ANIMALS.add(nala);
        ANIMALS.add(ella);

        // --- enclosures ---
        Enclosure lionsPen = new EnclosureLeo();
        Enclosure elephantPen = new EnclosureElephant();

        ENCLOSURES.add(lionsPen);
        ENCLOSURES.add(elephantPen);

        // --- assign animals ---
        lionsPen.addAnimal(leo);
        lionsPen.addAnimal(nala);
        elephantPen.addAnimal(ella);
    }

    public static void run() {
        while (true) {
            showMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> addInfoAnimal();
                case 2 -> addInfoEnclosure();
                case 3 -> addAnimalToEnclosure();
                case 4 -> displayEnclosures();
                case 5 -> {
                    System.out.println("Good-bye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static <T> T selectFromList(List<T> list, String prompt) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " → " + list.get(i));
        }
        System.out.print(prompt + " (index) : ");
        int idx = readInt();
        if (idx < 0 || idx >= list.size()) {
            System.out.println("Invalid index.");
            return null;
        }
        return list.get(idx);
    }

    public static void runDemo() {
        preloadData();
        run();
    }
}
