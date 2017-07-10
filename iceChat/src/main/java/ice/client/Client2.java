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

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.UUID;

public class Client2 extends Ice.Application
{
    public int
    run(String[] args)
    {

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
        System.out.println( "cccc"+server.ice_isTwoway());
        System.out.println( "cccc"+server.ice_isOneway());
        communicator().waitForShutdown();

        return 0;
    }

    private void send(TomPrx server, Identity ident) {
        boolean flag = true;
        while (flag){
            Scanner sc = new Scanner(System.in);
            String context = sc.nextLine();
            if("quit".equals(context)){
                break;
            }
            Message msg =  new Message();
            msg.msg="点赞";
            msg.srcUserId="12";
            msg.context="{context:\"" + context + "\"}";
            msg.toUserId="11";
            server.begin_addMsg(ident,msg, new Callback_Tom_addMsg() {
                public void response() {
                    System.out.println("client2发送成功 内容为： " + msg);
                }

                public void exception(LocalException e) {

                }
            }  );
        }
    }

    public static void main(String[] args) {
        Client2 app = new Client2();
        InitializationData data =   new InitializationData();
        int status = app.main("client2", new String[]{"12"});
        System.exit(status);
    }


    public static TomPrx server = null;




}
