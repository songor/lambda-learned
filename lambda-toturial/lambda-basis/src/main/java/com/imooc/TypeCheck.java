package com.imooc;

import java.util.ArrayList;
import java.util.List;

public class TypeCheck {

    private static void test(ILambda<String, List<String>> inter) {
        List<String> list = inter.strategy("element", new ArrayList<>());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test((e, list) -> {
            list.add(e);
            return list;
        });
    }

    @FunctionalInterface
    interface ILambda<T, R> {
        R strategy(T t, R r);
    }
}


