package com.isharpever.practice.executor;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {

    public static void main(String[] args) {
        test3();
    }

    private static void test1() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.thenAcceptAsync(result -> {
            System.out.println(result + " world");
        });

        completableFuture.complete("hello");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("hello");

        completableFuture.thenAcceptAsync(result -> {
            System.out.println(result + " world");
        });

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test3() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });

        completableFuture.thenAcceptAsync(result -> {
            System.out.println(result + " world");
        });

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
