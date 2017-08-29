package com.ian.sblog.domain;

public class Message {
    private String msg;
    private String err;

    public Message() {

    }

    public Message(String msg, String err) {
        this.msg = msg;
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
