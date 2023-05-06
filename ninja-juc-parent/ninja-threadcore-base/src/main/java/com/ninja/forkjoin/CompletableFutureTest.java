package com.ninja.forkjoin;

import java.util.concurrent.CompletableFuture;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2021/3/4
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        while (true) {
            CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
