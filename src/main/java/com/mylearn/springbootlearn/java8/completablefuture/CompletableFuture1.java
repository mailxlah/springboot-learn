package com.mylearn.springbootlearn.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * 创建 CompletableFuture
 *
 * @author biezhi
 * @date 2018/3/25
 */
public class CompletableFuture1 {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> helloFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello future"+Thread.currentThread().getName());
            }
        });

        CompletableFuture<String> aaaa = CompletableFuture.completedFuture("aaaa");
        System.out.println(aaaa.get());

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(
            new Supplier<Integer>() {
                @Override
                public Integer get() {
                    System.out.println(Thread.currentThread().getName());
                    return 2333;
                }
            });
        try {
            System.out.println(integerCompletableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}