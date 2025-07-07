package org.example;

public interface Enclosure {
    void addAnimal(Animal animal);
    void showAnimals();

    default String toStringDefault() {
        return getClass().getSimpleName();
    }
}
