package com.guoer.common.response;

import java.io.Serializable;


public class R<T> implements Serializable {

    public static final int SUCCESS = 10000;
    public static final int ERROR = 50000;
    public static final int LOGIN_TIME_OUT = 10101;

    private int code = SUCCESS;

    private boolean success;

    private String message;

    private T result;

    public static R fail() {
        R<Object> r = new R<>();
        r.setCode(ERROR);
        r.setSuccess(false);
        r.setMessage("操作失败");
        return r;
    }

    public static R fail(String message) {
        R<Object> r = new R<>();
        r.setCode(ERROR);
        r.setSuccess(false);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> fail(T data, String message) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setCode(ERROR);
        r.setSuccess(false);
        r.setResult(data);
        return r;
    }

    public static R fail(int code, String message) {
        R<Object> r = new R<>();
        r.setCode(code);
        r.setSuccess(false);
        r.setMessage(message);
        return r;
    }

    public static R ok() {
        R<Object> r = new R<>();
        r.setMessage("操作成功");
        r.setSuccess(true);
        return r;
    }

    public static R ok(String message) {
        R<Object> r = new R<>();
        r.setSuccess(true);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> ok(T data, String message) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setSuccess(true);
        r.setResult(data);
        return r;
    }

    public static <T> R<T> ok(int code, T data,String message) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setSuccess(true);
        r.setCode(code);
        r.setResult(data);
        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setMessage("操作成功");
        r.setSuccess(true);
        r.setResult(data);
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}