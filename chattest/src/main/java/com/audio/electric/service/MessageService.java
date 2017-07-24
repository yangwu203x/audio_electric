package com.audio.electric.service;

import com.mongodb.WriteResult;
import general.Message;
import org.springframework.stereotype.Component;

/**
 * Created by yangwu on 2017/3/28 0028.
 */
@Component
public interface MessageService {

    /**
     * 保存消息
     * @param msg
     * @return
     */
    void saveMessage(Message msg);

    void saveMessage(Message[] msgs);

    WriteResult removeMessage(String userId);

    Message[] getMessage(String userId);

}
