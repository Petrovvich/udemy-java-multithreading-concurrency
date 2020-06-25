package ru.petrovich.thread.termination.example;

import lombok.SneakyThrows;

/**
 * Thread Termination & Daemon Threads
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
    }

    private static class BlockingTask implements Runnable {

        @Override
        @SneakyThrows
        public void run() {
            //do things
            Thread.sleep(500000);
        }
    }
}
