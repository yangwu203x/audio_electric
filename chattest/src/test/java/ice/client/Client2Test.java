package ice.client;


import Ice.InitializationData;
import general.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/20 0020 16:03
 */
public class Client2Test {

    public static void main(String[] args){
        String srcUserId1 = "1";
        String srcUserId2 = "2";
        String srcUserId3 = "3";
        String srcUserId4 = "4";
        Thread t1 = send(srcUserId1);
        Thread t2 = send(srcUserId2);
        Thread t3 = send(srcUserId3);
        Thread t4 = send(srcUserId4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static Thread send(String srcUserId){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                List<Message> msgs = new ArrayList<>();
                for (int i =1; i < 10;i++){
                    Message msg =  new Message();
                    msg.msg = "点赞";
                    msg.srcUserId = srcUserId;
                    msg.context = "{context:\"发送者为："+srcUserId+",发送的第"+i+"条消息\"}";
                    msg.toUserId = "0";
                    msgs.add(msg);
                }
                Client2 app = new Client2(srcUserId);
                app.setMsgs(msgs);
                InitializationData data =   new InitializationData();
                int status = app.main("client"+srcUserId, new String[]{app.getSrcUserId()});
                System.exit(status);
            }
        });
    }

}