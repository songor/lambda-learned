# lambda-learned

### 什么是 Lambda

* Lambda 概述

  * Lambda 表达式也被称为箭头函数、匿名函数、闭包
  * Lambda 表达式体现的是轻量级函数式编程思想
  * “->” 符号是 Lambda 表达式核心操作符号，符号左侧是操作参数，符号右侧是操作表达式
  * JDK8 新特性

* Model Code As Data（MCAD 模式）

  * Model Code As Data，编码即数据，尽可能轻量级地将代码封装为数据
  * 解决方案：接口 & 实现类（匿名内部类）
  * 存在问题：语法冗余、this 关键字、变量捕获、数据控制等

* 问题及优化

  lambda-toturial/lambda-introduce/com.imooc.lambda.ThreadImpl

* 为什么要用 Lambda

  * 它不是解决未知问题的新技术
  * 对现有解决方案的语义化优化
  * 需要根据实际需求考虑性能问题

### Lambda 基础

* 函数式接口（functional interface）
  
  * 就是 Java 类型系统中的接口
  * 只包含一个接口方法的特殊接口
  * 语义化检测注解 @FunctionalInterface
  * 默认接口方法
  * 静态接口方法
  * 函数式接口，只包含一个操作方法；Lambda 表达式，只能操作一个方法；Java 中的 Lambda 表达式，核心就是一个函数式接口的实现
  * lambda-toturial/lambda-basis/com.imooc.lambda.IMessageFormat 和 lambda-toturial/lambda-basis/com.imooc.lambda.IUserCredential
  
* 常见的函数接口
  * Runnable / Comparable / Comparator / FileFilter / ...
  * JDK8 提供了 java.util.function 包，提供了常用的函数式功能接口
  * Predicate\<T\> 接受参数对象 T，返回一个 boolean 类型结果
  * Comsumer\<T\> 接受参数对象 T，不返回结果
  * Function\<T, R\> 接受参数对象 T，返回结果对象 R
  * Supplier\<T\> 不接受参数，提供 T 对象的创建工厂
  * UnaryOperator\<T\> 接受参数对象 T，返回结果对象 T
  * BinaryOperator\<T\> 接受两个参数对象 T，返回一个结果对象 T
  * lambda-toturial/lambda-basis/com.imooc.App
  
* Lambda 基本语法
  * \[接口声明\] = (参数) -> {执行代码块};
  * 声明：lambda 表达式绑定的接口类型
  * 参数：包含在 () 中，和绑定接口中的抽象方法的参数类型、个数及顺序一致，参数类型可以不指定
  * 操作符：“->”
  * 执行代码块：包含在 {} 中，出现在操作符的右侧，如果只有一行，可以省略 {} 和 return
  * lambda-toturial/lambda-basis/com.imooc.App
  
* 变量捕获

  * 匿名内部类中的变量捕获（this 表示当前内部类的对象）
  * Lambda 表达式中的变量捕获（this 表示所属方法所在类的对象）
  * lambda-toturial/lambda-basis/com.imooc.Variable

* 类型检查

  * 表达式类型检查
  * 参数类型检查
  * lambda-toturial/lambda-basis/com.imooc.TypeCheck

* 方法重载

  lambda-toturial/lambda-basis/com.imooc.LambdaOverride

* Lambda 运行原理

  * Lambda 表达式在 JVM 底层解析成私有静态方法（lambda$main$0）和匿名内部类（LambdaAnalysis$$Lambda$1）
  * 通过调用匿名内部类中的接口方法，调用私有静态方法，完成 Lambda 表达式的执行
  * lambda-toturial/lambda-basis/com/imooc/LambdaAnalysis.java

### Lambda 高级

* 方法引用

  * 方法引用是结合 Lambda 表达式的一种语法特性

  * 静态方法引用

    类名.方法名() -> 类名::方法名

  * 实例方法引用

    对象名.方法名() -> 对象名::方法名

  * 构造方法引用

    绑定函数式接口

  * lambda-toturial/lambda-advanced/com.imooc.lambda.MethodReference

* Stream API

  * Stream 聚合操作

    * 类型转换（其他类型 -> Stream）
    * 类型转换（Stream -> 其他类型）
    * 基本数据类型的功能封装
    * map / filter / forEach / peek / skip / limit / distinct / sorted / max / min / reduce

  * Stream 处理流程

    数据源 -> 数据转换 -> 获取结果

  * 获取 Stream 对象

    * 从集合或者数组中获取

      Collection.stream() / Collection.parallelStream() / Arrays.stream(T t)

    * BufferedReader.lines() / Files.lines()

    * java.util.stream.*

      IntStream.range()

    * java.util.Spliterator

    * 其它

      Random.ints() / Pattern.splitAsStream()

  * 中间操作（intermediate）

    返回一个 Stream，可以有一个或多个连续的中间操作；需要注意的是，中间操作只记录操作方式，不做具体的执行，直到结束操作发生时，才做数据的最终执行；中间操作就是业务逻辑处理

    中间操作过程（是否受前置中间操作的影响）：无状态（map / filter / peek / parallel / sequential / unordered）、有状态（distinct / sorted / limit / skip）

  * 终结操作（terminal）

    一个 Stream 只能有一个终结操作，这个操作一旦发生，就会真实处理数据，生成对应的处理结果

    终结操作过程：非短路操作（处理完集合中的所有数据，才能得到处理结果，forEach / forEachOrdered / toArray / reduce / collect / min / max / count / iterator）、短路操作（一旦满足某个条件，就可以得到结果，anyMatch / allMatch / noneMatch / findFirst / findAny / ...）

  * lambda-toturial/lambda-advanced/com.imooc.lambda.StreamAPI

* Stream 原理

* 实际需求重构

* 线程安全与性能