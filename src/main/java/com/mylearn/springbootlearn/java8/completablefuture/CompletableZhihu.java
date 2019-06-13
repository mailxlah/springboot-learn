package com.mylearn.springbootlearn.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @date 2019-05-23 19:42
 */
public class CompletableZhihu {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // m1();
    // m2();
    // m3();
    // m4();
    // m5();
    // m6();
    // m7();
    m8();
  }

  private static void m8() {

    StringBuilder result = new StringBuilder();
    List messages = Arrays.asList("a", "b", "c");
    List<CompletableFuture> futures = (List<CompletableFuture>) messages.stream()
        .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> s.toString().toUpperCase()))
        .collect(Collectors.toList());
    CompletableFuture<Void> done = CompletableFuture
        .allOf(futures.toArray(new CompletableFuture[futures.size()]))
        .whenComplete(new BiConsumer<Void, Throwable>() {
          @Override
          public void accept(Void v, Throwable th) {
            futures.forEach(new Consumer<CompletableFuture>() {
              @Override
              public void accept(CompletableFuture cf) {
                System.out.println(cf.getNow(null));
              }
            });
            System.out.println(Thread.currentThread().getName());
            result.append("done");
          }
        });
    done.join();
    System.out.println(result);

  }

  private static void m7() {

    StringBuilder result = new StringBuilder();
    List messages = Arrays.asList("a", "b", "c");
    List<CompletableFuture> futures = (List<CompletableFuture>) messages.stream()
        .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> s.toString().toUpperCase()))
        .collect(Collectors.toList());
    CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
      if(th == null) {
        System.out.println(res);
        result.append(res);
      }
    });
    System.out.println(result);
    System.out.println(result.length() > 0);
  }

  private static void m6() throws ExecutionException, InterruptedException {

    String original = "Message";
    CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(
        new Function<String, String>() {
          @Override
          public String apply(String s) {
            return s.toUpperCase();
          }
        })
        .thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(
            new Function<String, String>() {
              @Override
              public String apply(String s) {
                return s.toLowerCase();
              }
            })
            .thenApply(new Function<String, String>() {
              @Override
              public String apply(String s) {
                return upper + s;
              }
            }));
    System.out.println(cf.get());
  }

  private static void m5() {


    String original = "Message";
    CompletableFuture cf = CompletableFuture.completedFuture(original)
        .thenApplyAsync(new Function<String, String>() {
          @Override
          public String apply(String s) {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
          }
        })
        .thenCombine(CompletableFuture.completedFuture(original).thenApplyAsync(s -> s.toLowerCase()),
            (s1, s2) -> s1 + s2);
    try {
      System.out.println(cf.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

  }

  private static void m4() {

    String original = "Message";
    StringBuilder result = new StringBuilder();
    CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
        CompletableFuture.completedFuture(original).thenApply(new Function<String, String>() {
          @Override
          public String apply(String s) {
            System.out.println(Thread.currentThread().getName());
            return s.toLowerCase();
          }
        }),
        (s1, s2) -> result.append(s1 + s2));
    System.out.println(result.toString());
  }

  private static void m3() {

    String original = "Message";
    StringBuilder result = new StringBuilder();
    CompletableFuture.completedFuture(original).thenApply(new Function<String, String>() {
      @Override
      public String apply(String s) {
        System.out.println(s);
        return s.toUpperCase();
      }
    }).runAfterBoth(
        CompletableFuture.completedFuture(original).thenApply(new Function<String, String>() {
          @Override
          public String apply(String s) {
            System.out.println(s);
            return s.toLowerCase();
          }
        }),
        new Runnable() {
          @Override
          public void run() {
            result.append(original).append("aa");
          }
        });
    System.out.println(result.toString());
  }

  private static void m2() {

    String original = "Message";
    CompletableFuture cf1 = CompletableFuture.completedFuture(original)
        .thenApplyAsync(s -> s.toUpperCase());
    CompletableFuture cf2 = cf1.applyToEither(
        CompletableFuture.completedFuture("aa").thenApplyAsync(s -> s.toLowerCase()),
        s -> s + " from applyToEither");
    System.out.println(cf2.join());
  }

  private static void m1() {

    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(
        new Function<String, String>() {
          @Override
          public String apply(String s) {
            return s.toUpperCase();
          }
        });
    CompletableFuture exceptionHandler = cf.handle((s, th) -> { return (th != null) ? "message upon cancel" : ""; });
    cf.completeExceptionally(new RuntimeException("completed exceptionally"));
    cf.isCompletedExceptionally();
    try {
      Object join = cf.join();

      // fail("Should have thrown an exception");
    } catch(Exception ex) {
      ex.printStackTrace();
      // just for testing
      // assertEquals("completed exceptionally", ex.getCause().getMessage());
    }
    // assertEquals("message upon cancel", exceptionHandler.join());
  }

}
