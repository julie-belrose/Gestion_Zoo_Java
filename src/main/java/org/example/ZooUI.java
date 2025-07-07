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

    private static int readIntSafe() {
        while (true) {
            String line = SCANNER.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Not a number, try again: ");
            }
        }
    }

    private static String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            if (!line.isEmpty())
                return line;
            System.out.println("Input cannot be empty, please try again.");
        }
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
        Enclosure leosEnclosure = new EnclosureLeo();
        Enclosure elephantsEnclosure = new EnclosureElephant();

        ENCLOSURES.add(leosEnclosure);
        ENCLOSURES.add(elephantsEnclosure);

        // --- assign animals ---
        leosEnclosure.addAnimal(leo);
        leosEnclosure.addAnimal(nala);
        elephantsEnclosure.addAnimal(ella);
    }

    public static void run() {
        while (true) {
            showMenu();
            int choice = readIntSafe();

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
        int idx = readIntSafe();
        if (idx < 0 || idx >= list.size()) {
            System.out.println("Invalid index.");
            return null;
        }
        return list.get(idx);
    }

    private static void addInfoAnimal() {
        Species species = Species.fromString(
                readNonEmptyLine("Animal type (leo / elephant): ")
        );
        if (species == null) {
            System.out.println("Unsupported animal type.");
            return;
        }

        String name = readNonEmptyLine("Name: ");
        System.out.print("Age : ");
        int age = readIntSafe();

        Animal animal = species.create(name, age, SCANNER);

        if (animal != null) {
            ANIMALS.add(animal);
            System.out.println(animal.getName() + " created.");
        }
    }

    private static void addInfoEnclosure() {
        System.out.print("Enclosure type (leo / elephant): ");
        Species species = Species.fromString(SCANNER.nextLine());

        if (species == null) {
            System.out.println("Unknown enclosure type.");
            return;
        }

        switch (species) {
            case LEO      -> ENCLOSURES.add(new EnclosureLeo());
            case ELEPHANT -> ENCLOSURES.add(new EnclosureElephant());
        }
        System.out.println(species + " enclosure created.");
    }

    private static void addAnimalToEnclosure() {
        if (ANIMALS.isEmpty() || ENCLOSURES.isEmpty()) {
            System.out.println("Add at least one animal and one enclosure first.");
            return;
        }

        Animal chosenAnimal = selectFromList(ANIMALS, "Animal");
        Enclosure chosenEnclosure = selectFromList(ENCLOSURES, "Enclosure");

        if (chosenAnimal != null && chosenEnclosure != null) {
            chosenEnclosure.addAnimal(chosenAnimal);
        }
    }

    private static void displayEnclosures() {
        if (ENCLOSURES.isEmpty()) {
            System.out.println("No enclosures yet.");
            return;
        }
        ENCLOSURES.forEach(enclosure -> {
            System.out.println("\n--- " + enclosure.getClass().getSimpleName() + " ---");
            enclosure.showAnimals();
        });
    }

    public static void runDemo() {
        preloadData();
        displayEnclosures();
        run();
    }
}
