package ru.innopolis.stc13.proxy;

public class JavaTrainer implements Trainer {
    @Override
    public void teach() {
        System.out.println("Java is really complicated");
    }

    @Override
    public void eat() {
        System.out.println("i like to eat mango");
    }

    @Override
    public void talk() {
        System.out.println("where is your homework?");
    }
}
