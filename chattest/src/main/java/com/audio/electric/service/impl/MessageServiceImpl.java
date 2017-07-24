package com.audio.electric.service.impl;

import com.audio.electric.service.MessageService;
import com.audio.electric.template.MessageTemplate;
import com.mongodb.WriteResult;
import general.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/6 0006 20:56
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService{
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageTemplate messageTemplate;

    public void saveMessage(Message msg){
        messageTemplate.save(msg);
    }

    public void saveMessage(Message[] msgs){
        List<Message> msgList = new ArrayList<>();
        for (Message msg : msgs)
            msgList.add(msg);
        messageTemplate.saveAll(msgList);
    }

    public WriteResult removeMessage(String userId){
        return messageTemplate.updateMulti(query(where("toUserId").is(userId)), Update.update("status","1"));
    }

    public Message[] getMessage(String userId){
        List<Message> msgList = messageTemplate.find(query(where("toUserId").is(userId).and("status").is("0")));
        return msgList.toArray(new Message[]{});
    }

}
