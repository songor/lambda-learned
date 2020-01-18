package com.imooc.lambda;

/**
 * 函数式接口
 */
@FunctionalInterface
public interface IUserCredential {

    String verifyUser(String username);

    /**
     * 默认接口方法
     *
     * @param username
     * @return
     */
    default String getCredential(String username) {
        if ("admin".equals(username)) {
            return "Admin-Credential";
        } else {
            return "User-Credential";
        }
    }

}
