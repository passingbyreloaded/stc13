package ru.innopolis.stc13.hw4;

import java.util.ArrayList;
import java.util.List;

public class IncrementCounterThread extends CounterThread {

    private List<Thread> notifiers = new ArrayList<>();
    private int limit;

    public IncrementCounterThread(Counter counter, int limit, List<Thread> notifiers) {
        super(counter);
        this.limit = limit;
        this.notifiers = notifiers;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (counter) {
                counter.increment();
//                System.out.println(counter.get());
                if (counter.get() == limit) {
                    interrupt();
                    for (Thread thread : notifiers) {
                        thread.interrupt();
                    }
                }
                counter.notifyAll();
            }
        }
    }
}
