package org.example;

public class Leo extends Animal{

    Leo(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Leo" + name + " is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Leo" + name + " is sleeping.");
    }

    @Override
    public void makeSound() {
        System.out.println("Leo" + name + " roars");
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
