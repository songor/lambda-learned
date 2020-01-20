package com.imooc.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(5);
        personList.add(new Person("A", "male", 18));
        personList.add(new Person("B", "female", 25));
        personList.add(new Person("C", "female", 20));
        personList.add(new Person("D", "male", 28));
        personList.add(new Person("E", "male", 15));

        // 匿名内部类
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        System.out.println(personList);
        Collections.shuffle(personList);

        // lambda 表达式
        Collections.sort(personList, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(personList);
        Collections.shuffle(personList);

        // 静态方法引用
        Collections.sort(personList, Person::compareByAge);
        System.out.println(personList);
        Collections.shuffle(personList);

        // 实例方法引用
        PersonUtil personUtil = new PersonUtil();
        Collections.sort(personList, personUtil::compareByName);

        // 构造方法引用
        IPerson person = Person::new;
        Person p = person.initPerson("Init", "male", 35);
        System.out.println(p);
    }

}
