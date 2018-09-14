package ru.innopolis.stc13.syncronized;

public class Main2 {

    static Integer lock1 = 1;
    static Integer lock2 = 2;

    public static void main(String[] args) {     //deadlock
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {

                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {

                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
