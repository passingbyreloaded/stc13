package ru.innopolis.stc13.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);

        SlaveThread slaveThread = new SlaveThread();
        long start = System.currentTimeMillis();
        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            futures.add(CompletableFuture.supplyAsync(slaveThread::count, threadPool));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            try {
                value += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Execution time: " + (System.currentTimeMillis() - start));
        threadPool.shutdown();
    }
}
