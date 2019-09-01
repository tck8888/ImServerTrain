package com.tck.imservertrain.utils;

/**
 * description:</br>
 * created on: 2019/8/30 9:44</br>
 *
 * @author tck
 * @version 1.0
 */
public class TCKJSONResult {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok;	// 不使用

    public static TCKJSONResult build(Integer status, String msg, Object data) {
        return new TCKJSONResult(status, msg, data);
    }

    public static TCKJSONResult ok(Object data) {
        return new TCKJSONResult(data);
    }

    public static TCKJSONResult ok() {
        return new TCKJSONResult(null);
    }

    public static TCKJSONResult errorMsg(String msg) {
        return new TCKJSONResult(500, msg, null);
    }

    public static TCKJSONResult errorMap(Object data) {
        return new TCKJSONResult(501, "error", data);
    }

    public static TCKJSONResult errorTokenMsg(String msg) {
        return new TCKJSONResult(502, msg, null);
    }

    public static TCKJSONResult errorException(String msg) {
        return new TCKJSONResult(555, msg, null);
    }

    public TCKJSONResult() {

    }

//    public static LeeJSONResult build(Integer status, String msg) {
//        return new LeeJSONResult(status, msg, null);
//    }

    public TCKJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public TCKJSONResult(Object data) {
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
