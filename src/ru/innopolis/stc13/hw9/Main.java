package ru.innopolis.stc13.hw9;

import ru.innopolis.stc13.hw3.Delirium;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static List<String> list = new CopyOnWriteArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {

        final AtomicBoolean working = new AtomicBoolean(true);

        new Thread(() -> {
            while (working.get()) {
                for (int i = 0; i < 100; i++) {
                    list.add(Delirium.genWord(random.nextInt(1_000_000) + 300_000));
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new Thread(() -> {
//            while (working.get()) {
//                for (int i = 0; i < 40; i++) {
//                    list.remove(random.nextInt(list.size()));
//                }
//                try {
//                    Thread.sleep(700);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        working.set(false);
        System.out.println(list.size());
    }
}
