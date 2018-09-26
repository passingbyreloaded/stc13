package ru.innopolis.stc13.threadpool;

public class SlaveThread {

    public Double count() {
        double sum = 0;
        for (int i = 0; i < 5_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
