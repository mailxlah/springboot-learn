package com.mylearn.springbootlearn.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

public class LongAccumulator1 {

    public static void main(String[] args) {
        testAccumulate();
    }

    private static void testAccumulate() {
        LongBinaryOperator op          = (x, y) -> 2 * x + y;
        LongAccumulator    accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10).mapToObj(i -> (Runnable) () -> accumulator.accumulate(i)).forEach(executor::submit);

        ConcurrentUtils.stop(executor);

        System.out.format("Add: %d\n", accumulator.getThenReset());
    }
}