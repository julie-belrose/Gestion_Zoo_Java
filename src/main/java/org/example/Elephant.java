package org.example;

public class Elephant extends Animal {

    final double weight;

    Elephant(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }

    @Override
    public void eat() {
        System.out.println("Elephant" + name + " is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Elephant" + name + " is sleeping.");
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant" + name + " trumpets");
    }
}
