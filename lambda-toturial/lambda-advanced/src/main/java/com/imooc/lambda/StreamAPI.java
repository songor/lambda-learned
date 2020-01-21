package com.imooc.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        /**
         * 类型转换（其他类型 -> Stream）
         */
        // 多个数据
        Stream<String> strStream = Stream.of("Tom", "Jerry", "Peter", "Leslie", "Jagger");

        // 数组
        String[] array = new String[]{"Tom", "Jerry", "Peter", "Leslie", "Jagger"};
        Stream<String> arrayStream = Arrays.stream(array);

        // List
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Peter");
        list.add("Leslie");
        list.add("Jagger");
        Stream<String> listStream = list.stream();

        // Set
        Set<String> set = new HashSet<>();
        set.add("Tom");
        set.add("Jerry");
        set.add("Peter");
        set.add("Leslie");
        set.add("Jagger");
        Stream<String> setStream = set.stream();

        // Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 90);
        map.put("Jerry", 85);
        map.put("Peter", 83);
        map.put("Leslie", 92);
        map.put("Jagger", 79);
        Stream<String> mapKeyStream = map.keySet().stream();
        Stream<Integer> mapValueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> mapEntryStream = map.entrySet().stream();

        /**
         * 基本数据类型的功能封装
         */
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::print);
        System.out.println();

        IntStream.range(1, 6).forEach(System.out::print);
        System.out.println();

        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println();

        /**
         * 类型转换（Stream -> 其他类型）
         */
        // 数组
        String[] strArray = arrayStream.toArray(String[]::new);
        System.out.println("Array: " + Arrays.toString(strArray));

        // 字符串
        String str = strStream.collect(Collectors.joining(","));
        System.out.println("Str: " + str);

        // List
        List<String> strList = listStream.collect(Collectors.toList());
        System.out.println("List: " + strList);

        // Set
        Set<String> strSet = setStream.collect(Collectors.toSet());
        System.out.println("Set: " + strSet);

        // Map
        Set<String> mapKey = mapKeyStream.collect(Collectors.toSet());
        System.out.println("MapKey: " + mapKey);
        List<Integer> mapValue = mapValueStream.collect(Collectors.toList());
        System.out.println("MapValue: " + mapValue);
        Map<String, Integer> mapEntry = mapEntryStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("MapEntry: " + mapEntry);

        /**
         * API
         */
        List<String> accountList = new ArrayList<>();
        accountList.add("Tom");
        accountList.add("Jerry");
        accountList.add("Peter");
        accountList.add("Leslie");
        accountList.add("Jagger");
        accountList.add("Repeated");
        accountList.add("Repeated");

        // map()
        System.out.println(accountList.stream().map(account -> "User-" + account).collect(Collectors.toList()));

        // filter()
        System.out.println(accountList.stream().filter(account -> account.length() > 5).collect(Collectors.toList()));

        // forEach()
        accountList.forEach(System.out::println);

        // peek()
        accountList.stream().peek(account -> System.out.println("User-" + account))
                .peek(account -> System.out.println("Admin-" + account)).forEach(System.out::println);

        // skip()
        System.out.println(accountList.stream().skip(3).collect(Collectors.toList()));

        // limit()
        System.out.println(accountList.stream().limit(3).collect(Collectors.toList()));

        // distinct()
        System.out.println(accountList.stream().distinct().collect(Collectors.toList()));

        // sorted()
        System.out.println(Stream.of(1, 3, 2, 6, 5).sorted().collect(Collectors.toList()));

        // max()
        System.out.println(Stream.of(1, 3, 2, 6, 5).max(Comparator.comparingInt(x -> x)).get());

        // min()
        System.out.println(Stream.of(1, 3, 2, 6, 5).min(Comparator.comparingInt(x -> x)).get());

        // reduce()
        System.out.println(Stream.of(1, 3, 2, 6, 5).reduce((sum, num) -> sum + num).get());
    }

}
