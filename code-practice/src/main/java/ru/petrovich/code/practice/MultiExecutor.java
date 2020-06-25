package ru.petrovich.code.practice;
import java.util.List;

public class MultiExecutor {

    private final List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        for (Runnable run: tasks) {
            Thread thread = new Thread(run);
            thread.start();
        }
    }
}
