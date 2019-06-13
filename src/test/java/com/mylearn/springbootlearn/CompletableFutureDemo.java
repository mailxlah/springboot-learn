package com.mylearn.springbootlearn;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    // @Test
    public static void test1() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), executorService)
                                .thenApply(h->{
                                    System.out.println(Thread.currentThread().getName());
                                    return  Integer.toString(h) + "a";
                                })
                                .whenComplete((s, e) -> {
                                    // System.out.println("任务"+s+"完成!result="+s+"，异常 e="+e+","+new Date());
                                    list.add(s);
                                })
                ).toArray(CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(cfs).join();
        while (!executorService.isTerminated()) {
            executorService.shutdown();
        }
        System.out.println("list="+list+",耗时="+(System.currentTimeMillis()-start));
    }

    public static void main(String[] args) throws InterruptedException {
        // test1();
        // test2();
        // test3();
        // test4();
        // String s = test5();
        // System.out.println(s);
        test6();
    }

    private static void test6() {
        String s = "<p>日志数据接入验证mmmm</p><p><br></p><p>关键日志记录</p><p><br></p>";
        String s1 = delHtmlTag(s);
        System.out.println(s1);
    }

    public static String delHtmlTag(String str){
        String newstr = "";
        newstr = str.replaceAll("<[.[^>]]*>","");
        newstr = newstr.replaceAll(" ", "");
        return newstr;
    }

    private static String test5() {
        int i = 1;
        try {
            // i = 5 / 0;
            return String.valueOf(3);
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            System.out.println("aaa");
        }

        return String.valueOf(4);



    }


    private static void test4() {

        Multimap<String, Integer> reViewMapping = ArrayListMultimap.create();
        reViewMapping.put("1",10003);//服务器运行稳定	服务器宕机率
        reViewMapping.put("2",10001);//服务器性能消耗	服务器承载压力
        reViewMapping.put("3", 10004);//?用户数据无异常	缓存管理
        reViewMapping.put("4",10005);//客户端	客户端性能消耗是否达标+崩溃率
        reViewMapping.put("4", 10010);//客户端	客户端性能消耗是否达标+崩溃率
        reViewMapping.put("5", 10006);//兼容性	机型适配
        reViewMapping.put("6", 10007);//游戏品质	游戏品质
        reViewMapping.put("7", 10017);//转化率	新增转化率
        reViewMapping.put("8", 10018);//断线重连	客户端网络瞬断处理是否达标
        reViewMapping.put("9", 10020);//不同网络环境适配度	不同网络环境适应度
        reViewMapping.put("10", 10021);//安全	安全漏洞
        reViewMapping.put("11", 10026);//其他	日志数据接入验证+关键日志记录
        reViewMapping.put("11", 10025);//其他	日志数据接入验证+关键日志记录
        reViewMapping.put("12", 10029);//运维	运维架构文档、部署文档、运维CheckList齐备 + 高可用容灾能力 + 运维和监控工具是否具备
        reViewMapping.put("12", 10035);//运维	运维架构文档、部署文档、运维CheckList齐备 + 高可用容灾能力 + 运维和监控工具是否具备
        reViewMapping.put("12", 10034);//运维	运维架构文档、部署文档、运维CheckList齐备 + 高可用容灾能力 + 运维和监控工具是否具备

        System.out.println(reViewMapping);
    }

    private static void test3() {
        String s1 = new String("1");    // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
         // s1.intern();            // 常量池中的已经存在
        String s2 = "1";
        // s2.intern();
         System.out.println(s1 == s2);    // false
    }

    private static void test2() {
        int i = 3;
        for (int j = 0; j < i; j++) {

            if (j == 0) {
                continue;
            }
            System.out.println("j:"+j);
        }
        System.out.println("aaa");
    }

    public static int calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
