package com.saludtoolsjava.models;

public class ApiResponse {

    private Boolean ok;
    private String msg;
    private Object data;

    public ApiResponse(Boolean ok, String msg, Object data) {
        this.ok = ok;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
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
