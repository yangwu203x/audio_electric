package com.audio.electric.service.impl;

import com.audio.electric.template.MessageTemplate;
import general.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/20 0020 14:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MessageTemplateTest {
    @Autowired
    private MessageTemplate messageTemplate;
    @Test
    public void saveMessage() throws Exception {
    }

    @Test
    public void saveMessage1() throws Exception {
        Message msg =  new Message();
        msg.msg="点赞";
        msg.srcUserId="11";
        msg.context="{context:\"呵呵呃呃呃\"}";
        msg.toUserId="12";
        Message msg2 =  new Message();
        msg.msg="点赞";
        msg.srcUserId="11";
        msg.context="{context:\"呵呵呃呃呃\"}";
        msg.toUserId="12";
        List<Message> msgList = new ArrayList<>();
        msgList.add(msg);
        msgList.add(msg2);
        messageTemplate.saveAll(msgList);
    }

    @Test
    public void removeMessage() throws Exception {
        messageTemplate.updateMulti(query(where("toUserId").is("11")), Update.update("status","0"));
    }

    @Test
    public void getMessage() throws Exception {
        List<Message> msgList = messageTemplate.find(query(where("toUserId").is("11").and("status").is("0")));
        System.out.println(msgList.size());
    }

}