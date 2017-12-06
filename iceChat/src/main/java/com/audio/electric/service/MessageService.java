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
     int saveMessage(Message msg);

     int saveMessage(Message[] msgs1);

     int removeMessage(String userId);

     Message[] getMessage(String userId);
}
