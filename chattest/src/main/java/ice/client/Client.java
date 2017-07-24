package ice.client;


import Ice.*;
import com.audio.electric.util.DateStyle;
import com.audio.electric.util.DateUtil;
import general.Callback_Tom_addMsg;
import general.Message;
import general.TomPrx;
import general.TomPrxHelper;
import ice.servant.AppI;
import ice.utils.Information;
import org.slf4j.*;
import org.slf4j.Logger;

import java.util.Scanner;
import java.util.UUID;

public class Client extends Ice.Application
{
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    
    private static int state = 0;
    private static Client client = null;

    public int run(String[] args)
    {
            //创建代理服务，查看服务有没有开启
            server = TomPrxHelper.checkedCast(communicator().stringToProxy("tom:tcp -h localhost -p 10001"));
            if(server == null)
            {
                logger.info("invalid proxy");
                return 1;
            }

            //创建对象适配器
            Ice.ObjectAdapter adapter = communicator().createObjectAdapter("");
            ident.name = UUID.randomUUID().toString();
            ident.category = "";
            adapter.add(new AppI(), ident);
            //激活适配器
            adapter.activate();
            server.ice_getConnection().setAdapter(adapter);
            //与服务器建立双向连接
            server.ice_getConnection().setCallback(new ConnectionCallback() {
                public void heartbeat(Connection connection) {
                    System.out.println(DateUtil.now(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()) + "  ------  心跳 ---------  ");
                }


                public void closed(Connection connection) {
                    state = 0;
                    System.out.print("------------------关闭链接--------------------------");
                }
            });
            //注册客户代理
            server.begin_addClient(ident,args[0]);
            System.out.println("ok");
            if(state == 0)
                send();
             state = 1;


            System.out.println( "cccc"+server.ice_isTwoway());
            System.out.println( "cccc"+server.ice_isOneway());
            communicator().waitForShutdown();

        return 0;
    }

    //发送消息
    private void send() {
            server.begin_addMsg(ident,msg, new Callback_Tom_addMsg() {
                public void response() {
                    System.out.println("client2发送成功 内容为： " + msg);
                }
                public void exception(LocalException e) {

                }
            });
    }

    //点赞
    //评论
    //关注
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            String context = sc.nextLine();
            if ("quit".equals(context))
                break;
            String toUserId = "12";
            sendMsg(context, toUserId, Information.GOODS);
        }

    }

    /**
     * 官方、点赞、评论、关注
     * @param context 消息内容{context: "+ context + "}
     * @param toUserId 发送对象
     * @param in 消息发送类型
     */
    public static void sendMsg(String context, String toUserId, Information in) {
        Message msg =  new Message();
        StringBuffer sb = new StringBuffer("{context:\"");
        sb.append(context).append("\"}");
        msg.msg = in.getMsg();
        msg.srcUserId = in.getSrcUserId();
        msg.context = sb.toString();
        msg.toUserId = toUserId;
        sendMsg(msg );
    }

    /**
     * 发送消息
     * @param msg
     */
    private static void sendMsg(Message msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client app = Client.getInstance(msg);
                if (Client.state == 1){
                    app.send();
                }else{
                    InitializationData data =   new InitializationData();
                    int status = app.main("Client", new String[]{Information.OFFICIAL.getSrcUserId()});
                    System.exit(status);
                }
            }
        }).start();
    }

    //单例模式
    public static Client getInstance(Message msg){
        if (client != null){
        }else{
            synchronized (Client.class){
                client = new Client();
            }
        }
        client.msg = msg;
        return client;
    }
    //构造器私有化
    private Client(){}
    //消息内容
    private Message msg;
    private static TomPrx server;
    private static Identity ident = new Identity();
}
