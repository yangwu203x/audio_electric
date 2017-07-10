package com.audio.electric.domain;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/20 0020 17:34
 */
public class Message {
    public String msg;//消息描述

    public String srcUserId;//发送者id

    public String toUserId;//接受者id

    public String msgId;//消息id

    public String context;//消息内容

    public String state;//状态：0：未发送；1：已发送

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSrcUserId() {
        return srcUserId;
    }

    public void setSrcUserId(String srcUserId) {
        this.srcUserId = srcUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
