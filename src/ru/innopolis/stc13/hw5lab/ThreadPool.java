package ru.innopolis.stc13.hw5lab;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

    private boolean isWorking;
    private Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();

    public ThreadPool(int limit) {
        isWorking = true;
        for (int i = 0; i < limit; i++) {
            new Thread(() -> {
                while (isWorking) {
                    Runnable nextTask = tasks.poll();
                    if (nextTask != null) {
                        nextTask.run();
                    }
                }
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

    public boolean allTasksDone() {
        return tasks.isEmpty();
    }

}
