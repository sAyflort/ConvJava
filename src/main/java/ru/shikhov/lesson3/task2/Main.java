package ru.shikhov.lesson3.task2;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    locker.lock();
                    counter.inc();
                    System.out.println(Thread.currentThread().getName() + ": " + counter.getCount());
                    locker.unlock();
                }
            }).start();
        }
    }

    private static class Counter {
        int count;

        public void inc() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
