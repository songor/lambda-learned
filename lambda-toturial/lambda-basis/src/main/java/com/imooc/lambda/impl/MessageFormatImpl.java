package com.imooc.lambda.impl;

import com.imooc.lambda.IMessageFormat;

public class MessageFormatImpl implements IMessageFormat {

    @Override
    public String format(String message, String type) {
        return "Message [" + message + "] format to " + type;
    }

}
