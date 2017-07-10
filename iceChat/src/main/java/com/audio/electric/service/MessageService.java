package com.audio.electric.service;

import general.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangwu on 2017/3/28 0028.
 */
public interface MessageService {

    /**
     * 保存消息
     * @param msg
     * @return
     */
    public int saveMessage(Message msg);

    public int saveMessage(Message[] msgs1);

    public int removeMessage(String userId);

    public Message[] getMessage(String userId);
}
