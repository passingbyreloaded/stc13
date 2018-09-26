package ru.innopolis.stc13.methodreference;

public class Main {

    public static void main(String[] args) {
        Greeter sayhi = GreeterImlp::sayHi;
        sayhi.sayHi();
    }
}
