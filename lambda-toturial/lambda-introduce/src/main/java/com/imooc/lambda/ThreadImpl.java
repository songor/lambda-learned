package com.imooc.lambda;

public class ThreadImpl {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getId());
        }).start();
    }

}
