package com.mylearn.springbootlearn.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * 原子变量
 * <p>
 * AtomicInteger
 * LongAdder
 * LongAccumulator
 *
 * @author biezhi
 * @date 2018/3/5
 */
public class Atomic1 {

    private static final int NUM_INCREMENTS = 10;

    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public static void main(String[] args) {
        testIncrement();
       testAccumulate();
       testUpdate();
    }

    private static void testUpdate() {
        atomicInt.set(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int i) {
                        Runnable task = new Runnable() {
                            @Override
                            public void run() {
                                atomicInt.updateAndGet(new IntUnaryOperator() {
                                    @Override
                                    public int applyAsInt(int operand) {
                                        System.out.println("aa" + operand);
                                        return operand + 2;
                                    }
                                });
                            }
                        };
                        executor.submit(task);
                    }
                });

        for (int i = 0; i < 10; i++) {

        }

        ConcurrentUtils.stop(executor);

        System.out.format("Update: %d\n", atomicInt.get());
    }

    private static void testAccumulate() {
        atomicInt.set(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.accumulateAndGet(i, (n, m) -> n + m);
                    executor.submit(task);
                });

        ConcurrentUtils.stop(executor);

        System.out.format("Accumulate: %d\n", atomicInt.get());
    }

    private static void testIncrement() {
        atomicInt.set(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));

        ConcurrentUtils.stop(executor);

        System.out.format("Increment: Expected=%d; Is=%d\n", NUM_INCREMENTS, atomicInt.get());
    }
}