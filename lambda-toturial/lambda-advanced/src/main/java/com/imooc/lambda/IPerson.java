package com.imooc.lambda;

@FunctionalInterface
public interface IPerson {

    Person initPerson(String name, String gender, int age);

}
