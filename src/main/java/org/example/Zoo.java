package org.example;

public class Zoo {
    public static void createAnimal(){
        Leo leo = new Leo("Leo", 5);
        Elephant ella = new Elephant("Ella", 10, 3200);

        EnclosureLeo lionPen = new EnclosureLeo();
        EnclosureElephant elephantPen = new EnclosureElephant();

        lionPen.addAnimal(leo);
        elephantPen.addAnimal(ella);

        System.out.println("=== Leos ===");
        lionPen.showAnimals();
        System.out.println("=== Elephants ===");
        elephantPen.showAnimals();
    }
}
