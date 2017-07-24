package ice.client;// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// **********************************************************************


import Ice.*;
import com.audio.electric.util.DateStyle;
import com.audio.electric.util.DateUtil;
import general.Callback_Tom_addMsg;
import general.Message;
import general.TomPrx;
import general.TomPrxHelper;
import ice.servant.AppI;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Client2 extends Ice.Application {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(Client2.class);
    private String srcUserId;
    private List<Message> msgs;

    public Client2(String srcUserId) {
        this.srcUserId = srcUserId;
    }

    public List<Message> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Message> msgs) {
        this.msgs = msgs;
    }

    public String getSrcUserId() {
        return srcUserId;
    }

    public void setSrcUserId(String srcUserId) {
        this.srcUserId = srcUserId;
    }

    public int run(String[] args){

        //创建代理服务，查看服务有没有开启
        TomPrx server = TomPrxHelper.checkedCast(communicator().stringToProxy("tom:tcp -h localhost -p 10001"));
        if(server == null)
        {
            System.err.println("invalid proxy");
            return 1;
        }

        //创建对象适配器
        Ice.ObjectAdapter adapter = communicator().createObjectAdapter("");

        Ice.Identity ident = new Ice.Identity();
        ident.name = UUID.randomUUID().toString();
        ident.category = "";
        adapter.add(new AppI(), ident);
        //激活适配器
        adapter.activate();
        server.ice_getConnection().setAdapter(adapter);

        server.ice_getConnection().setCallback(new ConnectionCallback() {
            public void heartbeat(Connection connection) {
                System.out.println(DateUtil.now(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()) + "  ------  心跳 ---------  ");
            }

            public void closed(Connection connection) {
                System.out.print("------------------关闭链接--------------------------");
            }
        });
        server.begin_addClient(ident,args[0]);
        send(server, ident);
        logger.info( "ice_isTwoway6="+server.ice_isTwoway());
        logger.info( "ice_isOneway="+server.ice_isOneway());
        communicator().waitForShutdown();

        return 0;
    }

    private void send(TomPrx server, Identity ident) {
        for (int i = 0;msgs != null && i < msgs.size();i++){
            Message msg = msgs.get(i);
            //发送消息
            server.begin_addMsg(ident,msg, new Callback_Tom_addMsg() {
                public void response() {
                    logger.info("client2发送成功内容为： " + msg);
                }
                public void exception(LocalException e) {
                    logger.info("client2发送失败，原因是：" + e.getMessage());
                }
            }  );
        }

//        boolean flag = true;
//        while (flag){
//            Scanner sc = new Scanner(System.in);
//            String context = sc.nextLine();
//            if("quit".equals(context)){
//                break;
//            }
//            Message msg =  new Message();
//            msg.msg="点赞";
//            msg.srcUserId="11";
//            msg.context="{context:\"" + context + "\"}";
//            msg.toUserId="12";
//            server.begin_addMsg(ident,msg, new Callback_Tom_addMsg() {
//                public void response() {
//                    logger.info("client2发送成功 内容为： " + msg);
//                }
//
//                public void exception(LocalException e) {
//
//                }
//            }  );
//        }
    }

    public static void main(String[] args) {
        String srcUserId = args[0];
        Client2 app = new Client2(srcUserId);
        InitializationData data =   new InitializationData();
        List<Message> msgs = new ArrayList<>();
        for (int i =1; i < 10;i++){
            Message msg =  new Message();
            msg.msg = "点赞";
            msg.srcUserId = srcUserId;
            msg.context = "{context:\"发送者为："+srcUserId+",发送的第"+i+"条消息\"}";
            msg.toUserId = "0";
            msgs.add(msg);
        }
        app.setMsgs(msgs);
        int status = app.main("client2", new String[]{app.getSrcUserId()});
        System.exit(status);
    }


    public static TomPrx server = null;




}
