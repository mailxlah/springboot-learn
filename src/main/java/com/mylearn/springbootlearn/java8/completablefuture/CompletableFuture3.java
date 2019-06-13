package com.mylearn.springbootlearn.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 结果转换
 *
 * @author biezhi
 * @date 2018/3/25
 */
public class CompletableFuture3 {

    public static void main(String[] args) {
        try {
            String result = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return 2333;
                }
            })
                    .thenApply(new Function<Integer, String>() {
                        @Override
                        public String apply(Integer obj) {
                            return String.valueOf(obj)+"----"+Thread.currentThread().getName();
                        }
                    }).get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}