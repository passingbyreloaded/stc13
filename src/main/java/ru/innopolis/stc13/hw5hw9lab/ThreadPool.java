package ru.innopolis.stc13.hw5hw9lab;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {

    private boolean isWorking;
    private Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();
    private AtomicInteger aliveThreads = new AtomicInteger(0);

    public ThreadPool(int limit) {
        isWorking = true;
        for (int i = 0; i < limit; i++) {
            new Thread(() -> {
                aliveThreads.incrementAndGet();
                while (isWorking) {
                    Runnable nextTask = tasks.poll();
                    if (nextTask != null) {
                        nextTask.run();
                    }
                }
                aliveThreads.decrementAndGet();
            }).start();
        }
    }

    public void startTask(Runnable runnable) {
        if (isWorking) {
            tasks.offer(runnable);
        }
    }

    public void shutDown() {
        isWorking = false;
    }

    public boolean allTasksTaken() {
        return tasks.isEmpty();
    }

    public boolean allTasksDone() {
        return aliveThreads.get() == 0;
    }
}
