package com.ian.sblog.util;

import com.ian.sblog.domain.Message;

public class MessageFactory {
    public static Message message = new Message();

    public static Message getMessage(){
        if (message != null){
            return message;
        }else{
            message = new Message();
        }
        return message;
    }

}
