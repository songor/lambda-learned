package com.imooc;

public class LambdaOverride {

    @FunctionalInterface
    interface IConsolePrint {
        void output(String message);
    }

    @FunctionalInterface
    interface ILogPrint {
        void output(String message);
    }

    public void write(IConsolePrint print) {
        print.output("It's a message");
    }

    public void write(ILogPrint print) {
        print.output("It's a message");
    }

    public static void main(String[] args) {
        LambdaOverride lambdaOverride = new LambdaOverride();
        lambdaOverride.write(new IConsolePrint() {
            @Override
            public void output(String message) {
                System.out.println("console message => [" + message + "]");
            }
        });

        lambdaOverride.write(new ILogPrint() {
            @Override
            public void output(String message) {
                System.out.println("log message => [" + message + "]");
            }
        });

//        lambdaOverride.write((message) -> System.out.println("This is illegal"));
        lambdaOverride.write((IConsolePrint) (message) -> System.out.println("lambda console message => [" + message + "]"));
        lambdaOverride.write((ILogPrint) (message) -> System.out.println("lambda log message => [" + message + "]"));
    }
}
