package com.imooc.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroduce {

    public static void main(String[] args) {
        List<String> accountList = new ArrayList<>();
        accountList.add("Tom");
        accountList.add("Jerry");
        accountList.add("Peter");
        accountList.add("Leslie");
        accountList.add("Jagger");
        accountList.add("Gavin");
        accountList.add("Joe");

        List<String> accounts = new ArrayList<>();
        for (String account : accountList) {
            if (account.length() >= 5) {
                accounts.add(account);
            }
        }
        System.out.println("Foreach - Length greater than 5: " + accounts);
        accounts.clear();

        Iterator<String> iterator = accountList.iterator();
        while (iterator.hasNext()) {
            String account = iterator.next();
            if (account.length() >= 5) {
                accounts.add(account);
            }
        }
        System.out.println("Iterator - Length greater than 5: " + accounts);
        accounts.clear();

        accounts = accountList.stream().filter(account -> account.length() >= 5).collect(Collectors.toList());
        System.out.println("StreamIntroduce - Length greater than 5: " + accounts);
    }

}
