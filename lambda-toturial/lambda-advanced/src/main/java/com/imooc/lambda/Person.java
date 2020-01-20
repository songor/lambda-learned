package com.imooc.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private String gender;

    private int age;

    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

}
