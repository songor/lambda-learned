package com.imooc;

public class Variable {

    String globalVariable = "global";

    public void testAnonymousInnerClass() {
        String localVariable = "local";
        new Thread(new Runnable() {
            String innerVariable = "inner";

            @Override
            public void run() {
                System.out.println("Access global variable: " + globalVariable);
                System.out.println("Access local variable: " + localVariable);
//                localVariable = "";
                // this 表示当前内部类的对象
                System.out.println("Access inner variable: " + this.innerVariable);
            }
        }).start();
    }

    public void testLambda() {
        String localVariable = "local";
        new Thread(() -> {
            String innerVariable = "inner";
            // this 表示所属方法所在类的对象
            System.out.println("Access global variable: " + this.globalVariable);
            System.out.println("Access local variable: " + localVariable);
//            localVariable = "";
            System.out.println("Access inner variable: " + innerVariable);
        }).start();
    }

    public static void main(String[] args) {
        Variable variable = new Variable();
        variable.testAnonymousInnerClass();
        variable.testLambda();
    }

}
