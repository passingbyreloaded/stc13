package ru.innopolis.stc13.syncronized;

public class Store {

    private int products = 0;

    public synchronized void get() {
        while (products < 1) {
            System.out.println("wait for put");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products--;
        System.out.println("1 product purchased");
        notify();
    }

    public synchronized void put() {

        while (products >= 5) {
            System.out.println("wait for get");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products++;
        System.out.println("1 product supplied");
        System.out.println("Products in the storage: " + products);
        notify();
    }
}
