package com.ian.sblog.service.impl;

import com.ian.sblog.util.messsage.MsgType;
import com.ian.sblog.util.messsage.Message;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessage implements Message{
    private MsgType type;
    private String key;
    private Object msg;

    public SimpleMessage() {

    }

    public SimpleMessage(MsgType type, String key, String msg) {
        this.type = type;
        this.key = key;
        this.msg = msg;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
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
