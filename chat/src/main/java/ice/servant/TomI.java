package ice.servant;// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// **********************************************************************


import Ice.*;
import Ice.Optional;
import com.audio.electric.service.MessageService;
import com.audio.electric.util.ApplicationContextUtil;
import com.audio.electric.util.DateStyle;
import com.audio.electric.util.DateUtil;
import general.AppPrx;
import general.AppPrxHelper;
import general.Message;
import general._TomDisp;
import ice.servant.callback.Callback_App_receiveI;
import ice.servant.callback.Callback_App_receiveListI;
import ice.utils.PushMessage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class TomI extends _TomDisp {

    private static MessageService service = null;
    public TomI(Communicator communicator)
    {
        _communicator = communicator;
    }

    private Communicator _communicator;

    /**
     * 注册方法
     * @param ident
     * @param userId
     * @param __current
     */
    @Override
    public void addClient(Identity ident, String userId, Current __current) {
        if (service == null)
            service = (MessageService) ApplicationContextUtil.getBean(MessageService.class);
        //创建代理对象
        ObjectPrx base = __current.con.createProxy(ident);
        //创建心跳
        Optional<ACMHeartbeat> heartBeat = new Optional<ACMHeartbeat>();
        //三十秒发一次心跳
        heartBeat.set( ACMHeartbeat.HeartbeatAlways);
        __current.con.setACM(null,null,heartBeat);//设置Bidirectional Connections心跳

        AppPrx client = AppPrxHelper.uncheckedCast(base);
        _clients.put(userId,client);
        //根据userId取自己的离线消息

        Message[] msgs =  service.getMessage(userId);

        if(msgs != null && msgs.length > 0){
            client.begin_receiveList(msgs,new Callback_App_receiveListI(msgs));
        }
    }

    @Override
    public void addMsg(Identity ident, Message msg,  Current __current) {

        String  str =  msg.context;

        try {//时间统一为服务器时间
            JSONObject json = new JSONObject(str);
            json.put("time", DateUtil.now(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()));
            msg.context = json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if( _clients.get(msg.toUserId) == null){//对方不在线
              service.saveMessage(msg);
        }else {//对方在线
            _clients.get(msg.toUserId).begin_receive(msg, new Callback_App_receiveI(msg));
        }
        //推送消息
//        PushMessage.offLineMsgPush(msg);

    }
    @Override
    public void logoutClient(Identity ident, String userId, Current __current) {
        AppPrx prx = _clients.get(userId);
        if(prx != null){
            _clients.remove(userId);
            prx.ice_getConnection().close(true);

        }

    }


    public static  Map<String,AppPrx> _clients =  Collections.synchronizedMap(new HashMap<String, AppPrx>());

}
