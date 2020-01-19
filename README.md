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

  lambda-introduce/lambda-introduce/com.imooc.lambda.ThreadImpl

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
* 常见的函数接口
  * Runnable / Comparable / Comparator / FileFilter / ...
  * JDK8 提供了 java.util.function 包，提供了常用的函数式功能接口
  * Predicate\<T\> 接受参数对象 T，返回一个 boolean 类型结果
  * Comsumer\<T\> 接受参数对象 T，不返回结果
  * Function\<T, R\> 接受参数对象 T，返回结果对象 R
  * Supplier\<T\> 不接受参数，提供 T 对象的创建工厂
  * UnaryOperator\<T\> 接受参数对象 T，返回结果对象 T
  * BinaryOperator\<T\> 接受两个参数对象 T，返回一个结果对象 T
* Lambda 基本语法
  * [接口声明] = (参数) -> {执行代码块};
  * 声明：lambda 表达式绑定的接口类型
  * 参数：包含在 () 中，和绑定接口中的抽象方法的参数类型、个数及顺序一致，参数类型可以不指定
  * 操作符：“->”
  * 执行代码块：包含在 {} 中，出现在操作符的右侧，如果只有一行，可以省略 {} 和 return
* 变量捕获
* 类型检查
* Lambda 运行原理

### Lambda 高级

* 方法引用
* Stream API
* Stream 原理
* 集合元素操作
* 实际需求重构
* 线程安全与性能