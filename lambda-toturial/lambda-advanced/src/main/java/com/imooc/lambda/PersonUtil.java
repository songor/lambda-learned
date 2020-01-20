package com.imooc.lambda;

public class PersonUtil {

    public int compareByName(Person p1, Person p2) {
        return p1.getName().hashCode() - p2.getName().hashCode();
    }

}
