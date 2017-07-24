package com.audio.electric.template;

import general.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/20 0020 14:00
 */
@Component
public class MessageTemplate extends  MongoRepImp<Message> {
    private static Class<Message> entity = Message.class;
    @Autowired
    public MessageTemplate(MongoTemplate mongoTemplate) {
        super(entity, mongoTemplate);
    }
}
