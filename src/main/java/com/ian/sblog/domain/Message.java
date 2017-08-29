package com.ian.sblog.domain;

import java.util.Map;

public class Message {
    private String msg;
    private String err;
    private Map<String, Object> results;

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

    public Map<String, Object> getResults() {
        return results;
    }

    public void setResults(Map<String, Object> results) {
        this.results = results;
    }
}
