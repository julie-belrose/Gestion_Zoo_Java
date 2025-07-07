package org.example;

import java.util.ArrayList;
import java.util.List;

public class EnclosureElephant implements Enclosure {
    List<Elephant> elephants;

    // Constructor initialises the list
    public EnclosureElephant() {
        this.elephants = new ArrayList<>();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animal instanceof Elephant elephant) {
            elephants.add(elephant);
            System.out.println(elephant.name + " has been added.");
        } else {
            System.out.println("Only elephants are allowed in this enclosure!");
        }
    };

    @Override
    public void showAnimals() {
        for (Elephant elephant : elephants) {
            System.out.println(elephant.name);
        }
    };

    @Override
    public String toString() {
        return "Elephant enclosure (" + elephants.size() + " animals)";
    }
}
