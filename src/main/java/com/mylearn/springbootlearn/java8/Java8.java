package com.mylearn.springbootlearn.java8;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author biezhi
 * @date 2018/2/11
 */
public class Java8 {

    public static void main(String[] args) {
        List<Project> projects = Project.buildData();
        List<String> names = projects.stream().parallel()
                .filter(p -> {
                    System.out.println(p.getName()+"--f->"+Thread.currentThread().getName());
                    return p.getStars() > 1000;
                })
                .map(p -> {
                    System.out.println(p.getName()+"--m->"+Thread.currentThread().getName());
                    return p.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        // System.out.println(names);

        names.stream().forEach(name-> System.out.println(name));
    }

}