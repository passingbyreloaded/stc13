package ru.innopolis.stc13.proxywork;

public class SomeClass implements SomeInterface {
    @Logged
    @Override
    public void someMethod() {
        System.out.println("im doing some stuff");
    }
}
