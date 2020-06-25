package ru.petrovich.code.practice;

public class MinMaxMetrics {

    private volatile long min;
    private volatile long max;

    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        this.min = 0;
        this.max = 0;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public void addSample(long newSample) {
        synchronized (this) {
            this.min = Math.min(this.min, newSample);
            this.max = Math.max(this.max, newSample);
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return this.min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return this.max;
    }
}
