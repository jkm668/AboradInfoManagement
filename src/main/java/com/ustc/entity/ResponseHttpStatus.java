package com.ustc.entity;

public class ResponseHttpStatus {
    //http状态码
    private Integer code;

    //返回的提示消息
    private String msg;

    //返回的数据
    private Object data;

    public ResponseHttpStatus() {
    }

    //返回状态码、信息、以及数据
    public ResponseHttpStatus(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //只返回状态码及信息，用于异常时候使用
    public ResponseHttpStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //只返回状态码和数据
    public ResponseHttpStatus(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
}
