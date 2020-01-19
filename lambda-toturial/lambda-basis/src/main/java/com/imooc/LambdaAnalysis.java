public class LambdaAnalysis {

    public static void main(String[] args) {
        ITest test = (message) -> System.out.println(message);
        test.test("It's a message");
    }

}

interface ITest {
    void test(String message);
}

/**
 * （1）javac LambdaAnalysis.java
 * LambdaAnalysis.class
 * ITest.class
 * （2）javap -p LambdaAnalysis.class
 * public class com.imooc.LambdaAnalysis {
 *   public com.imooc.LambdaAnalysis();
 *   public static void main(java.lang.String[]);
 *   private static void lambda$main$0(java.lang.String);
 * }
 * lambda$main$0(java.lang.String) -> 调用 System.out.println(message);
 * main(java.lang.String[]) -> new LambdaAnalysis$$Lambda$1().test(message)
 * （3）java -Djdk.internal.lambda.dumpProxyClasses LambdaAnalysis
 * LambdaAnalysis$$Lambda$1.class
 * （4）javap -p LambdaAnalysis$$Lambda$1.class
 * final class LambdaAnalysis$$Lambda$1 implements ITest {
 *   private LambdaAnalysis$$Lambda$1();
 *   public void test(java.lang.String);
 * }
 * test(java.lang.String) -> 调用 LambdaAnalysis.lambda$main$0
（5）
 */