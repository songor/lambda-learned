package com.imooc.lambda.impl;

import com.imooc.lambda.IUserCredential;

public class UserCredentialImpl implements IUserCredential {

    @Override
    public String verifyUser(String username) {
        if ("admin".equals(username)) {
            return "Admin-Access";
        } else {
            return "User-Access";
        }
    }

}
