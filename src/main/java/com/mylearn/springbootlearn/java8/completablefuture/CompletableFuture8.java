package com.mylearn.springbootlearn.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author biezhi
 * @date 2018/3/25
 */
public class CompletableFuture8 {

    public static void main(String[] args) {
        try {
            String s = CompletableFuture.supplyAsync(new Supplier<Integer>() {
              @Override
              public Integer get() {
                System.out.println("111"+Thread.currentThread().getName());
                return 23333;
              }
            })
                    .thenCombine(CompletableFuture.supplyAsync(new Supplier<String>() {
                      @Override
                      public String get() {
                        System.out.println("aaa"+Thread.currentThread().getName());
                        return "8898";
                      }
                    }), new BiFunction<Integer, String, String>() {
                      @Override
                      public String apply(Integer a, String b) {
                        System.out.println("bb" + Thread.currentThread().getName());
                        System.out.println("a =" + a);
                        System.out.println("b =" + b);
                        return a + b;
                      }
                    })
                    .get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}