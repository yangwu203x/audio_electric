package ice.utils;

import com.audio.electric.util.ConfigUtils;
import com.audio.electric.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.xinge.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class XGPushUtil {
    private static Logger logger = LoggerFactory.getLogger(XGPushUtil.class);
    static  String  key = ConfigUtils.getString("xgPushSecretKey");
    static long appId = StringUtils.toLong(ConfigUtils.getString("xgaAcessId"),2100248669L);

    private XingeApp xinge;
    private Message message1;
    private Message message2;
    private MessageIOS messageIOS;
    public XGPushUtil() {
        xinge = new XingeApp(appId,key);
        buildMesssges();
    }

    protected void buildMesssges() {
        message1 = new Message();
        message1.setType(Message.TYPE_NOTIFICATION);
        Style style = new Style(1);
        style = new Style(3, 1, 0, 1, 0);
        ClickAction action = new ClickAction();
        action.setActionType(ClickAction.TYPE_URL);
        action.setUrl("http://xg.qq.com");
        Map<String, Object> custom = new HashMap<String, Object>();
        custom.put("key1", "value1");
        custom.put("key2", 2);
        message1.setTitle("title");
        message1.setContent("大小");
        message1.setStyle(style);
        message1.setAction(action);
        message1.setCustom(custom);
        TimeInterval acceptTime1 = new TimeInterval(0, 0, 23, 59);
        message1.addAcceptTime(acceptTime1);

        message2 = new Message();
        message2.setType(Message.TYPE_NOTIFICATION);
        message2.setTitle("title");
        message2.setContent("通知点击执行Intent测试");
        style = new Style(1);
        action = new ClickAction();
        action.setActionType(ClickAction.TYPE_INTENT);
        action.setIntent("intent:10086#Intent;scheme=tel;action=android.intent.action.DIAL;S.key=value;end");
        message2.setStyle(style);
        message2.setAction(action);

        messageIOS = new MessageIOS();
        messageIOS.setType(MessageIOS.TYPE_APNS_NOTIFICATION);
        messageIOS.setExpireTime(86400);
        messageIOS.setAlert("ios test");
        messageIOS.setBadge(1);
        messageIOS.setCategory("INVITE_CATEGORY");
        messageIOS.setSound("beep.wav");
    }
    public  String pushAccount(String title,String content,String userId,Map<String,Object> params){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",params);
        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        message.setCustom(map);
        message.setType(Message.TYPE_MESSAGE);
        message.setExpireTime(86400);
        JSONObject ret = xinge.pushSingleAccount(0, userId,message);
       logger.info(ret.toString());
        return ret.toString();
    }

    public static void main(String[] args) {
        Type DEFAULT_TYPE = new TypeToken<Map<String,Object>>() {
        }.getType();
        Map<String,Object> temp =   new Gson().fromJson("{aa:123}",DEFAULT_TYPE);
        System.out.println(temp);
        System.out.println("<><>" +  ConfigUtils.getString("xgPushSecretKey"));
        StringUtils.toLong(ConfigUtils.getString("xgaAcessId"),2100248669L);
        System.out.println("<>222<>" +  StringUtils.toLong(ConfigUtils.getString("xgaAcessId"),2100248669L));
    }
}