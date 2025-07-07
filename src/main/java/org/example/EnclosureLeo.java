package org.example;

import java.util.ArrayList;
import java.util.List;

public class EnclosureLeo implements Enclosure {

    List<Leo> leos;

    EnclosureLeo() {
        this.leos = new ArrayList<>();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animal instanceof Leo leo) {
            leos.add(leo);
            System.out.println(leo.name + " has been added.");
        } else {
            System.out.println("Only leos are allowed in this enclosure!");
        }
    }

    @Override
    public void showAnimals() {
        for (Leo leo : leos) {
            System.out.println(leo.name);
        }
    }

    @Override
    public String toString() {
        return "Leo enclosure (" + leos.size() + " animals)";
    }
}
