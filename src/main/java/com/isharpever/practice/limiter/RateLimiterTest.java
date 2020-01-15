package com.isharpever.practice.limiter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 1; i < 10; i += 2) {
            double waitSeconds = rateLimiter.acquire(i);
            System.out.println(waitSeconds);
        }
    }
}
