package com.isharpever.practice.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程,一个只打印A,一个只打印B,一个只打印C 控制它们依次打印ABCABC...
 */
public class OrderlyPrint {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition printA = lock.newCondition();
        Condition printB = lock.newCondition();
        Condition printC = lock.newCondition();

        Thread threadA = new Thread(new PrintThread("A", 1, 2, lock, printA, printB));
        threadA.setDaemon(false);
        threadA.start();
        Thread threadB = new Thread(new PrintThread("B", 2, 3, lock, printB, printC));
        threadB.setDaemon(false);
        threadB.start();
        Thread threadC = new Thread(new PrintThread("C", 3, 1, lock, printC, printA));
        threadC.setDaemon(false);
        threadC.start();
    }

    static class PrintThread implements Runnable {

        private String value;
        private static int signal = 1;
        private int selfSignal;
        private int nextSignal;
        private Lock lock;
        private Condition selfCondition;
        private Condition nextCondition;

        public PrintThread(String value, int selfSignal, int nextSignal, Lock lock,
                Condition selfCondition, Condition nextCondition) {
            this.value = value;
            this.selfSignal = selfSignal;
            this.nextSignal = nextSignal;
            this.lock = lock;
            this.selfCondition = selfCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            while (true) {
                this.lock.lock();
                try {
                    while (signal != this.selfSignal) {
                        try {
                            this.selfCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(this.value);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    signal = this.nextSignal;
                    this.nextCondition.signal();
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }
}
