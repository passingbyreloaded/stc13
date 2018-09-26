package ru.innopolis.stc13.hw4;

public class CounterThread extends Thread {

    protected Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }
}
