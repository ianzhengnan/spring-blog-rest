package com.ian.sblog.util.messsage;

public interface Message {

    void setMsg(Object message);

    Object getMsg();

    void setKey(Object key);

    Object getKey();

    void setType(MsgType type);

    MsgType getType();
}
