package com.mylearn.springbootlearn.java8;


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;

/**
 * 数值流
 * <p>
 * IntStream、DoubleStream、LongStream
 *
 * @author biezhi
 * @date 2018/2/12
 */
public class Example7 {

    public static void main(String[] args) {
        List<Project> projects = Project.buildData();
        // projects.stream().reduce(new BinaryOperator<Project>() {
        //     @Override
        //     public Project apply(Project project, Project project2) {
        //         return project;
        //     }
        // }).get();
        // projects.stream().map(project -> project.getAuthor()).forEach(s -> System.out.println(s));
        IntStream intStream = projects.stream()
            .mapToInt(p -> p.getStars());
        intStream.forEach(System.out::println);
        // OptionalInt max = intStream
        //         .max();
        // System.out.println(max.getAsInt());

        System.out.println("----");
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("tttttttt");
        System.out.println(s1.reduce(strings,
            new BiFunction<ArrayList<String>, String, ArrayList<String>>() {
                @Override
                public ArrayList<String> apply(ArrayList<String> u, String s) {
                    u.add(s);
                    return u;
                }
            }, new BinaryOperator<ArrayList<String>>() {
                @Override
                public ArrayList<String> apply(ArrayList<String> strings, ArrayList<String> strings2) {
                    return strings;
                }
            }));

        System.out.println("----");
        Stream.iterate(new Tuple(0, 1), tuple -> new Tuple(tuple.second, tuple.first + tuple.second))
            .limit(20)
            .forEach(tuple -> System.out.println("("+ tuple.first +","+ tuple.second +")"));
        System.out.println("----");

        System.out.println(projects.stream().map(Project::getName).limit(2).collect(Collectors.toList()));


        System.out.println("----");
        Integer biezhi = projects.stream()
            .filter(p -> p.getAuthor().equals("biezhi"))
            .map(p -> p.getStars())
            .reduce(0,
                Integer::sum);
        System.out.println(biezhi);

    }
    @AllArgsConstructor
    static class Tuple{
        int first;
        int second;
    }


}