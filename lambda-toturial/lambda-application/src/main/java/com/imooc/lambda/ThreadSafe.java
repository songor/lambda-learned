package com.imooc.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadSafe {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1_000);
        for (int i = 0; i < 1_000; i++) {
            list.add(i);
        }

        // Stream
        List<Integer> copy = new ArrayList<>(1_000);
        list.forEach(element -> copy.add(element));
        System.out.println("list size: " + list.size() + ", copy size: " + copy.size());

        // ParallelStream
        List<Integer> parallelCopy = new ArrayList<>(1_000);
        list.parallelStream().forEach(element -> parallelCopy.add(element));
        System.out.println("list size: " + list.size() + ", parallelCopy size: " + parallelCopy.size());

        List<Integer> parallelSafeCopy = list.parallelStream().collect(Collectors.toList());
        System.out.println("list size: " + list.size() + ", parallelSafeCopy size: " + parallelSafeCopy.size());

        List<Integer> parallelSafeCollectionCopy = Collections.synchronizedList(new ArrayList<>(1_000));
        list.parallelStream().forEach(element -> parallelSafeCollectionCopy.add(element));
        System.out.println("list size: " + list.size() + ", parallelSafeCollectionCopy size: " + parallelSafeCollectionCopy.size());
    }

}
