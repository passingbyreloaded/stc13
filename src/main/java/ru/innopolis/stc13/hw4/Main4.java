package ru.innopolis.stc13.hw4;

import java.util.ArrayList;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
        Counter counter = new Counter();
        NotifyCounterThread notifier1 = new NotifyCounterThread(counter, 3);
        NotifyCounterThread notifier2 = new NotifyCounterThread(counter, 5);
        NotifyCounterThread notifier3 = new NotifyCounterThread(counter, 11);
        List<Thread> list = new ArrayList<>();
        list.add(notifier1);
        list.add(notifier2);
        list.add(notifier3);
        IncrementCounterThread incrementer = new IncrementCounterThread(counter, 20, list);
        for (Thread thread : list) {
            thread.start();
        }
        incrementer.start();
    }
}
