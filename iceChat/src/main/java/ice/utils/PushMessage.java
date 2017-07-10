package ice.utils;

import com.audio.electric.service.MessageService;
import com.audio.electric.service.impl.MessageServiceImpl;
import com.audio.electric.util.ConfigUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liwang on 16/6/23.
 */
public class PushMessage {
private static Logger logger = LoggerFactory.getLogger(PushMessage.class); 
    public class Constant{

        public static final String priceChatTopic = "priceChatPush";
        public static final String typePriceChat = "1";
        public static final String typeMessage = "2";
    }


    static {
        //Constants.useSandbox();//切换测试
        Constants.useOfficial();
    }

    /**
     * 安卓推送给全部用户
     */
    public static void sendAdrAll(String secret, String packageName, String payload, String title, String description, Map<String, String> map) throws Exception {
        Sender sender = new Sender(secret);
        Message message = new Message.Builder().title(title).
                description(description).payload(payload).
                restrictedPackageName(packageName).extra("pushData", JSONObject.toJSONString(map))
                .notifyType(1).build();
        Result result = sender.broadcastAll(message, 1);
        logger.info(String.valueOf(result));
    }

    /**
     * 安卓推送给全部用户
     */
    public static void sendAdrAll(String secret, String packageName, String payload, String title, String description) throws Exception {

        Sender sender = new Sender(secret);
        Message message = new Message.Builder().title(title).
                description(description).payload(payload).
                restrictedPackageName(packageName)
                .notifyType(1).build();
        Result result = sender.broadcastAll(message, 1);
        logger.info(String.valueOf(result));
    }

    /**
     * 安卓推送指定用户
     */
    public static void sendAddr(String secret, String packageName, String payload, String title, String description, List<String> userId, Map<String, String> map) throws Exception {
        Sender sender = new Sender(secret);
        Message message = new Message.Builder().title(title).description(description).
                passThrough(0).payload(payload).restrictedPackageName(packageName).
                extra("pushData", JSONObject.toJSONString(map)).
                notifyType(1).build();
        Result result = sender.sendToAlias(message, userId, 1);
        logger.info(String.valueOf(result));
    }



    /**
     * Ios推送给全部用户
     */
    public static void sendIosAll(String secret, String description, Map<String, String> map) throws Exception {
        Sender sender = new Sender(secret);
        Message message = new Message.IOSBuilder().description(description).soundURL("default").extra("pushData", JSONObject.toJSONString(map)).build();
        Result result = sender.broadcastAll(message, 1);
        logger.info(String.valueOf(result));
    }

    /**
     * Ios推送给全部用户
     */
    public static void sendIosAll(String secret, String description) throws Exception {
        Sender sender = new Sender(secret);
        Message message = new Message.IOSBuilder().description(description).soundURL("default").build();
        Result result = sender.broadcastAll(message, 1);
        logger.info(String.valueOf(result));
    }

    /**
     * Ios推送指定用户
     */
    public static void sendIos(String secret, String description, List<String> userId, Map<String, String> map) throws Exception {
        Sender sender = new Sender(secret);
        Message message = new Message.IOSBuilder().description(description).soundURL("default").extra("pushData", JSONObject.toJSONString(map)).build();
        Result result = sender.sendToAlias(message, userId, 1);
        logger.info(String.valueOf(result));
    }

    /**
     * Ios推送制定客户全部用户
     */
    public static void sendIosAll(List<String> storeId, String secret, String description, Map<String, String> map) throws Exception {
        Sender sender = new Sender(secret);
        Message message = new Message.IOSBuilder().description(description).soundURL("default").extra("pushData", JSONObject.toJSONString(map)).build();
        Result result = sender.multiTopicBroadcast(message, storeId, Sender.BROADCAST_TOPIC_OP.EXCEPT, 1);
        logger.info(String.valueOf(result));
    }


    /**
     * 推送离线消息
     * @param msg
     */
    public static void offLineMsgPush(general.Message msg){

        try {
            org.json.JSONObject msgInfo = new org.json.JSONObject(msg.context);
            Map<String,Object> data = new  HashMap<String,Object>();
            data.put("type", Constant.typeMessage);

            data.put("data",new Gson().toJson(msg));
            int dot = 0;
//             if(MsgMapHelper.getMsgMap() .get(msg.toUserId) != null){
//                dot = MsgMapHelper.getMsgMap() .get(msg.toUserId).length ;
//            }
            MessageService service = new MessageServiceImpl();
            if(service.getMessage(msg.toUserId) != null){
                dot = service.getMessage(msg.toUserId).length ;
            }
            data.put("dot",dot);

             //发送动态消息
            if(msgInfo.has("contentTextType")){

                if("2".equals(msgInfo.getString("contentTextType")));
                msg.msg = "您收到一条动态消息！";
            }

            Message mimsg = new Message.Builder().
                    description(msg.msg).notifyType(-1)
                    .title(msgInfo.getString("name")).passThrough(0).payload(msg.msg).extra("data",new JSONObject(data).toString())
                    .extra(Constants.EXTRA_PARAM_NOTIFY_FOREGROUND, "0").extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_ACTIVITY)
                    .extra(Constants.EXTRA_PARAM_INTENT_URI,
                            "intent:#Intent;component=com.dodonew.travel/.ui.MainActivity;end").extra("notification_group", " chat")
                    .extra("notification_is_summary", "true")
                           .build();

            Message.IOSBuilder temp = new Message.IOSBuilder().soundURL("default");
            if(dot > 0)
                temp.badge(dot);

            Message iosmimeg = temp.description(msgInfo.getString("name")+":"+ msg.msg).extra("data",new JSONObject(data).toString()).build();
            sendToUserId(ConfigUtils.getString("miAppSecretAndroid"),mimsg,msg.toUserId);
            sendToUserId(ConfigUtils.getString("miAppSecretIOS"),iosmimeg,msg.toUserId);

           //信鸽
            Type DEFAULT_TYPE = new TypeToken<Map<String,Object>>() {
            }.getType();
            Gson g = new Gson();

            try {

                Map<String,Object> map =  g.fromJson(g.toJson(msg),DEFAULT_TYPE);
                String str = map.get("context").toString();
                map.put("context",g.fromJson(str,DEFAULT_TYPE));
                data.put("data",map);

            }catch (Exception e){

                e.printStackTrace();
            }

            new XGPushUtil().pushAccount(msgInfo.getString("name"),msg.msg,msg.toUserId, data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void sendTopic(String secret,Message msg,String topic){

        Sender sender = new Sender(secret);
        try {
            Result res = sender.broadcast(msg,topic,2);
            logger.info(String.valueOf(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendToUserId(String secret,Message msg,String userId){

        Sender sender = new Sender(secret);
        try {
            Result res = sender.sendToAlias(msg,userId,2);
          //  logger.info(String.valueOf(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Map<String,String> params = new HashMap<String, String>();
        sendIosAll("/acueeAoKSNP2a7rO4DNew==", "2333", params);
    }
}
