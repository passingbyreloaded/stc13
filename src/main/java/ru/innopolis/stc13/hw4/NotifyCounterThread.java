package ru.innopolis.stc13.hw4;

public class NotifyCounterThread extends CounterThread {

    private int seconds;

    public NotifyCounterThread(Counter counter, int seconds) {
        super(counter);
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (counter) {
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (counter.get() % seconds == 0) {
                    System.out.println(seconds + " sec");
                }
            }
        }
    }
}
