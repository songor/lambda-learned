package com.imooc;

import com.imooc.lambda.IMessageFormat;
import com.imooc.lambda.IUserCredential;
import com.imooc.lambda.impl.MessageFormatImpl;
import com.imooc.lambda.impl.UserCredentialImpl;

import java.util.UUID;
import java.util.function.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        /**
         * 函数式接口
         */
        IUserCredential uc = new UserCredentialImpl();
        System.out.println(uc.verifyUser("admin"));
        // 测试默认接口方法
        System.out.println(uc.getCredential("admin"));

        String message = "It's a message";
        // 测试静态接口方法
        if (IMessageFormat.isLegal(message)) {
            IMessageFormat format = new MessageFormatImpl();
            System.out.println(format.format(message, "json"));
        }

        // 匿名内部类
        uc = new IUserCredential() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username) ? "Anonymous-Admin-Access" : "Anonymous-User-Access";
            }
        };
        System.out.println(uc.verifyUser("admin"));

        // lambda 表达式
        uc = (String username) -> {
            return "admin".equals(username) ? "Anonymous-Admin-Access" : "Anonymous-User-Access";
        };
        System.out.println(uc.verifyUser("admin"));

        /**
         * java.util.function
         */
        // Predicate
        Predicate<String> predicate = (String username) -> {
            return "admin".equals(username);
        };
        System.out.println(predicate.test("admin"));

        // Consumer
        Consumer<String> consumer = (String msg) -> {
            System.out.println("Send message: " + msg);
        };
        consumer.accept("It's a message");

        // Function
        Function<String, Integer> function = (String gender) -> {
            return "male".equals(gender) ? 1 : 0;
        };
        System.out.println(function.apply("male"));

        // Supplier
        Supplier<String> supplier = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(supplier.get());

        // UnaryOperator
        UnaryOperator<String> unaryOperator = (String image) -> {
            return image += "[1024*768]";
        };
        System.out.println(unaryOperator.apply("source image"));

        // BinaryOperator
        BinaryOperator<Integer> binaryOperator = (Integer a, Integer b) -> {
            return a > b ? a : b;
        };
        System.out.println(binaryOperator.apply(5, 10));

        ILambdaWithoutParamAndResult lambdaWithoutParamAndResult = () -> {
            System.out.println("Without param and result");
        };
        lambdaWithoutParamAndResult.test();

        lambdaWithoutParamAndResult = () -> System.out.println("Without param and result simplify");
        lambdaWithoutParamAndResult.test();

        ILambdaWithParamButWithoutResult lambdaWithParamButWithoutResult = (String param) -> {
            System.out.println("With param but without result, param is: " + param);
        };
        lambdaWithParamButWithoutResult.test("Hello World");

        lambdaWithParamButWithoutResult = (param) -> {
            System.out.println("With param but without result simplify, param is: " + param);
        };
        lambdaWithParamButWithoutResult.test("Hello World");

        ILambdaWithParamAndResult lambdaWithParamAndResult = (param) -> {
            int result = param * 2 + 1;
            return result;
        };
        System.out.println("With param and result, result is: " + lambdaWithParamAndResult.test(5));

        lambdaWithParamAndResult = (param) -> param * 2 + 1;
        System.out.println("With param and result simplify, result is: " + lambdaWithParamAndResult.test(5));
    }

    interface ILambdaWithoutParamAndResult {
        void test();
    }

    interface ILambdaWithParamButWithoutResult {
        void test(String param);
    }

    interface ILambdaWithParamAndResult {
        int test(int param);
    }

}
