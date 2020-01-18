package com.imooc.lambda;

/**
 * 函数式接口
 */
@FunctionalInterface
public interface IMessageFormat {

    String format(String message, String type);

    /**
     * 静态接口方法
     *
     * @param message
     * @return
     */
    static boolean isLegal(String message) {
        return message != null && message.length() > 0;
    }

}
