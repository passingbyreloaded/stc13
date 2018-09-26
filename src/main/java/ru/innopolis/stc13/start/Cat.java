package ru.innopolis.stc13.start;

public class Cat extends Animal implements Running, Eating, Meowing {

    public Cat(String name, Integer nLegs) {
        super(name, nLegs);
    }

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    @Override
    public void meow() {
        System.out.println("Meow");
    }

    @Override
    public void run() {
        System.out.println("Cat runs");
    }
}
