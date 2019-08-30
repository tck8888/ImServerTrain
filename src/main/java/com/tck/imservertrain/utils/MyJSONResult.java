package com.tck.imservertrain.utils;

/**
 * description:</br>
 * created on: 2019/8/30 9:44</br>
 *
 * @author tck
 * @version 1.0
 */
public class MyJSONResult {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok;	// 不使用

    public static MyJSONResult build(Integer status, String msg, Object data) {
        return new MyJSONResult(status, msg, data);
    }

    public static MyJSONResult ok(Object data) {
        return new MyJSONResult(data);
    }

    public static MyJSONResult ok() {
        return new MyJSONResult(null);
    }

    public static MyJSONResult errorMsg(String msg) {
        return new MyJSONResult(500, msg, null);
    }

    public static MyJSONResult errorMap(Object data) {
        return new MyJSONResult(501, "error", data);
    }

    public static MyJSONResult errorTokenMsg(String msg) {
        return new MyJSONResult(502, msg, null);
    }

    public static MyJSONResult errorException(String msg) {
        return new MyJSONResult(555, msg, null);
    }

    public MyJSONResult() {

    }

//    public static LeeJSONResult build(Integer status, String msg) {
//        return new LeeJSONResult(status, msg, null);
//    }

    public MyJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public MyJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
