package org.example;

public abstract class Animal {
    final String name;
    final int age;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
    public abstract void sleep();
    public abstract void makeSound();

    @Override public String toString() {
        return name + " (" + age + " y)";
    }

    public String getName() {
        return name;
    }
}
