package com.mylearn.springbootlearn.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class Lock5 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        StampedLock lock = new StampedLock();
        final int[] i = {10};

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                ConcurrentUtils.sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                ConcurrentUtils.sleep(4);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                System.out.println(i[0]);
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                i[0]++;
                ConcurrentUtils.sleep(2);
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });

        ConcurrentUtils.stop(executor);
    }

}