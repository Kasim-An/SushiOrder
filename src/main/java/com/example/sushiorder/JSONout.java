package com.example.sushiorder;

public class JSONout<T> {
    private T date;
    private int code;
    private String msg;
    public JSONout(){

    }
    public JSONout(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public JSONout(T date, int code, String msg) {
        this.date = date;
        this.code = code;
        this.msg = msg;
    }
    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}