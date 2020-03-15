package com.isharpever.practice.limiter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

    public static void main(String[] args) {
        // 1s产生1个令牌,并且最大就存储1个令牌
        RateLimiter rateLimiter = RateLimiter.create(1);
        // 第1次:获取1个令牌,直接返回,内部设置下次能够获取令牌的时间是1s后
        // 第2次:获取3个令牌,等待1s后返回,内部设置下次能够获取令牌的时间是3s后
        // 第3次:获取5个令牌,等待3s后返回,内部设置下次能够获取令牌的时间是5s后
        // 第4次:获取7个令牌,等待5s后返回,内部设置下次能够获取令牌的时间是7s后
        // 第5次:获取9个令牌,等待7s后返回,内部设置下次能够获取令牌的时间是9s后
        // 退出循环
        for (int i = 1; i < 10; i += 2) {
            double waitSeconds = rateLimiter.acquire(i);
            System.out.println(waitSeconds);
        }
    }
}
