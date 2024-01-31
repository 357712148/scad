package com.dunshan.cloud;

/**
 * @description: 异常处理
 * @author: 李文
 * @create: 2024-01-31 11:30
 **/
public class GroupException extends RuntimeException {
    private Integer code;
    private String message;


    public GroupException() {

    }

    public GroupException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public GroupException(String message, Integer code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

