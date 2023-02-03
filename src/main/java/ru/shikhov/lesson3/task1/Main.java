package ru.shikhov.lesson3.task1;

public class Main {

    public static void main(String[] args) {
        SyncQueue syncQueue = new SyncQueue();
        new Thread(() -> {
            while (true) {
                syncQueue.printPing();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                syncQueue.printPong();
            }
        }).start();
    }

    private static class SyncQueue {
        boolean flag = false;
        synchronized void printPing() {
            while (!flag){
                try{
                    Thread.sleep(1000);
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + "Ping");
            flag = false;
            notify();
        }
        synchronized void printPong() {
            while (flag) {
                try {
                    Thread.sleep(1000);
                    wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + "Pong");
            flag = true;
            notify();
        }
    }
}
