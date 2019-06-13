package com.mylearn.springbootlearn.java8.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lock3 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Map<String, String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();
        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println("rrrrr");
                System.out.println(map.get("foo"));
                ConcurrentUtils.sleep(1);
            } finally {
                lock.readLock().unlock();
                System.out.println("rrrrrooooo");
            }
        };
        executor.submit(readTask);
        Runnable wtask = () -> {
            lock.writeLock().lock();
            try {
                System.out.println("wwwww");
                ConcurrentUtils.sleep(5);
                map.put("foo", "bar");
            } finally {
                lock.writeLock().unlock();
                System.out.println("wwwwwoooo");
            }
        };
        Runnable wtask2 = () -> {
            lock.writeLock().lock();
            try {
                System.out.println("wwwww");
                ConcurrentUtils.sleep(1);
                map.put("foo", "bar22");
            } finally {
                lock.writeLock().unlock();
                System.out.println("wwwwwoooo");
            }
        };
        executor.submit(wtask);
        executor.submit(wtask2);


        executor.submit(readTask);
        executor.submit(readTask);

        ConcurrentUtils.stop(executor);
    }

}