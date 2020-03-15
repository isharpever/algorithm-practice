package com.isharpever.practice.stock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程并发扣减本地库存
 */
public class Stock {

    private AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {
        Stock stock = new Stock();
        CountDownLatch cd = new CountDownLatch(1);

        Runnable r = () -> {
            try {
                cd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stock.reduce()) {
                System.out.println(Thread.currentThread().getName() + "购买成功");
            }
        };

        Thread a = new Thread(r);
        a.setName("a");
        a.setDaemon(false);

        Thread b = new Thread(r);
        b.setName("b");
        b.setDaemon(false);

        Thread c = new Thread(r);
        c.setName("c");
        c.setDaemon(false);

        a.start();
        b.start();
        c.start();
        cd.countDown();
    }

    private boolean reduce() {
        return num.decrementAndGet() > -1;
    }
}
