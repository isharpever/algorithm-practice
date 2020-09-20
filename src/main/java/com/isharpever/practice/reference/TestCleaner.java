package com.isharpever.practice.reference;

import sun.misc.Cleaner;

public class TestCleaner {
    public static void main(String[] args) {
        CleanerSampler sampler = new CleanerSampler();
        sampler = null;
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("cleaned");
    }
}

class CleanerSampler {
    private Cleaner cleaner = Cleaner.create(this, new CleanWorker());

    private static class CleanWorker implements Runnable {

        @Override
        public void run() {
            System.out.println("cleaning...");
        }
    }

    public Cleaner getCleaner() {
        return cleaner;
    }
}