package com.audio.electric.service.impl;

import com.audio.electric.service.MessageService;
import general.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/6 0006 20:56
 */
public class MessageServiceImpl implements MessageService{
    private Logger logger = LoggerFactory.getLogger(MessageService.class);
    private static Message msg = null;
    private static Message[] msgs = null;
    private static Map<String,Message[]> msgsMap = new HashMap<>();
    private static Map<String , Message> msgMap = new HashMap<>();
    public int saveMessage(Message msg){
        logger.info("保存消息：msg" + msg);
        if (msgsMap.get(msg.toUserId) != null){
            Message[] msgs = msgsMap.get(msg.toUserId);
            Message[] msgstemp = new Message[msgs.length + 1];
            int i = 0;
            for (Message msgtemp : msgs){
                msgstemp[i++] = msgtemp;
            }
            msgstemp[i++] = msg;
            msgsMap.put(msg.toUserId,msgstemp);
        }else{
            msgsMap.put(msg.toUserId,new Message[]{msg});
        }
        return 0;
    }

    public int saveMessage(Message[] msgs1){
        logger.info("保存消息：msg" + msgs1);
        if (msgs1 != null)
            if (msgsMap.get(msg.toUserId) != null){
                Message[] msgs = msgsMap.get(msg.toUserId);
                Message[] msgstemp = new Message[msgs.length + msgs1.length];
                int i = 0;
                for (Message msgtemp : msgs){
                    msgstemp[i++] = msgtemp;
                }
                for (Message msgtemp : msgs1){
                    msgstemp[i++] = msgtemp;
                }
                msgsMap.put(msg.toUserId,msgstemp);
            }else{
                msgsMap.put(msg.toUserId,new Message[]{msg});
            }
        return 0;
    }

    public int removeMessage(String userId){
        logger.info("删除消息：userId = " + userId);
        msgsMap.remove(userId);
        return 0;
    }

    public Message[] getMessage(String userId){

        return this.msgsMap.get(userId);
    }

//    public Message getMessage(String userId){
//        logger.info("查询到消息");
//        Message msg = new Message();
//        msg.msg="过来玩啊！";
//        msg.msgId ="1";
//        msg.srcUserId = "11";
//        msg.toUserId = "12";
//        return msg;
//    }
}
