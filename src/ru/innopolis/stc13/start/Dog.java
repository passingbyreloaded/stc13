package ru.innopolis.stc13.start;

public class Dog extends Animal implements Running {

    public Dog(String name, Integer nLegs) {
        super(name, nLegs);
    }

    @Override
    public void run() {
        System.out.println("Dog runs");
    }

}
