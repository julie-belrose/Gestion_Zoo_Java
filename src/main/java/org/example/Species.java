package org.example;

import java.util.Scanner;

public enum Species {
    LEO {
        @Override
        public Animal create(String name, int age, Scanner sc) {
            return new Leo(name, age);
        }
    },
    ELEPHANT {
        @Override
        public Animal create(String name, int age, Scanner sc) {
            System.out.print("Weight (kg): ");
            double weight = sc.nextDouble();
            sc.nextLine();
            return new Elephant(name, age, weight);
        }
    };

    public abstract Animal create(String name, int age, Scanner sc);

    public static Species fromString(String s) {
        return switch (s.trim().toLowerCase()) {
            case "leo", "lion"  -> LEO;
            case "elephant"     -> ELEPHANT;
            default             -> null;
        };
    }

    private static double readPositiveDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            try {
                double value = Double.parseDouble(line.trim());
                if (value > 0) return value;
            } catch (NumberFormatException ignore) { }
            System.out.print("Invalid number, try again: ");
        }
    }
}
