package ru.innopolis.stc13.multithreading;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(new CounterThread());
        thread.start();
        long res = 0;
        for (int i = 0; i < 590_000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            res += i;
        }
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
