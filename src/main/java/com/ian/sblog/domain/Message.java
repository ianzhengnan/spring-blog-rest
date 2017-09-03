package com.ian.sblog.domain;

import com.ian.sblog.util.messsage.MsgType;


public class Message {
    private MsgType type;
    private String key;
    private String msg;

    public Message() {

    }

    public Message(MsgType type, String key, String msg) {
        this.type = type;
        this.key = key;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
