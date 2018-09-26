package ru.innopolis.stc13.hw5hw9lab;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(6);

        pool.startTask(() -> {
            System.out.println(Thread.currentThread().getName() + "task 1 completed");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.startTask(() -> {
            System.out.println(Thread.currentThread().getName() + "task 2 completed");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.startTask(() -> {
            System.out.println(Thread.currentThread().getName() + "task 3 completed");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 4 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 5 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 6 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 7 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 8 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 9 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 10 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 11 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 12 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 13 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 14 completed"));
        pool.startTask(() -> System.out.println(Thread.currentThread().getName() + "task 15 completed"));
        while (true) {
            if (pool.allTasksDone()) {
                pool.shutDown();
                break;
            }
        }
    }
}
