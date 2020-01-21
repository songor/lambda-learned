package com.imooc;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        /**
         * Performance
         */
        Random random = new Random();

        List<Integer> integerList = new ArrayList<>(50_000_000);
        for (int i = 0; i < 50_000_000; i++) {
            integerList.add(random.nextInt(Integer.MAX_VALUE));
        }

        // Stream
        testStream(integerList);
        // parallelStream
        testParallelStream(integerList);
        // for
        testFor(integerList);
        // forEach
        testForEach(integerList);
        // Iterator
        testIterator(integerList);

    }

    private static void testStream(List<Integer> list) {
        LocalTime start = LocalTime.now();
        Integer max = list.stream().max(Integer::compareTo).get();
        System.out.println("Stream calculate max is: " + max);
        LocalTime end = LocalTime.now();
        System.out.println("Stream -> " + Duration.between(start, end).toMillis() + " ms");
    }

    private static void testParallelStream(List<Integer> list) {
        LocalTime start = LocalTime.now();
        Integer max = list.parallelStream().max(Integer::compareTo).get();
        System.out.println("ParallelStream calculate max is: " + max);
        LocalTime end = LocalTime.now();
        System.out.println("ParallelStream -> " + Duration.between(start, end).toMillis() + " ms");
    }

    private static void testFor(List<Integer> list) {
        LocalTime start = LocalTime.now();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current > max) {
                max = current;
            }
        }
        System.out.println("For calculate max is: " + max);
        LocalTime end = LocalTime.now();
        System.out.println("For -> " + Duration.between(start, end).toMillis() + " ms");
    }

    private static void testForEach(List<Integer> list) {
        LocalTime start = LocalTime.now();
        int max = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("ForEach calculate max is: " + max);
        LocalTime end = LocalTime.now();
        System.out.println("ForEach -> " + Duration.between(start, end).toMillis() + " ms");
    }

    private static void testIterator(List<Integer> list) {
        LocalTime start = LocalTime.now();
        Iterator<Integer> i = list.iterator();
        int max = i.next();
        while (i.hasNext()) {
            int current = i.next();
            if (current > max) {
                max = current;
            }
        }
        System.out.println("Iterator calculate max is: " + max);
        LocalTime end = LocalTime.now();
        System.out.println("Iterator -> " + Duration.between(start, end).toMillis() + " ms");
    }

}
