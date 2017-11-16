package com.example.demo.exception;

/**
 * Created by Jerry on 2017/8/15 0015.
 */
public class StuException extends RuntimeException{
    private Integer code;

    public StuException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
