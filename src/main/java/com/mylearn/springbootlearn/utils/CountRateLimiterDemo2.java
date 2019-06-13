package com.mylearn.springbootlearn.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CountRateLimiterDemo2 {

    private static Semaphore semphore = new Semaphore(5);
    AtomicInteger a=new AtomicInteger(10);

    public static void exec() {
        if (semphore.getQueueLength() > 10) {
            System.out.println("当前等待排队的任务数大于10，请稍候再试...");
        }
        try {
            semphore.acquire();
            // 处理核心逻辑
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("--" + System.currentTimeMillis() / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 200).forEach(
            i -> executorService.submit(() -> {
                System.out.println(i);
                exec();
            })

        );
    }
}