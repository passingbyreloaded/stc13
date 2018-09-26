package ru.innopolis.stc13.syncronized;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        Incrementor incrementor1 = new Incrementor(monitor);
        Incrementor incrementor2 = new Incrementor(monitor);
        incrementor1.start();
        incrementor2.start();
        incrementor1.join();
        incrementor2.join();
        System.out.println(monitor.getStore());
    }
}
