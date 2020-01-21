package com.imooc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(find(e -> e.length() > 2));
        System.out.println(find(e -> e.contains("A")));
    }

    private static List<String> find(IStrategy<String> strategy) {
        List<String> source = new ArrayList<>();
        source.add("A");
        source.add("BB");
        source.add("CCC");

        return source.stream().filter(strategy::apply).collect(Collectors.toList());
    }

}

@FunctionalInterface
interface IStrategy<T> {
    Boolean apply(T t);
}