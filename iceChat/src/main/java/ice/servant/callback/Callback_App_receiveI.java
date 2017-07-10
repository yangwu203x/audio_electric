package ice.servant.callback;

import Ice.LocalException;
import com.audio.electric.service.MessageService;
import com.audio.electric.service.impl.MessageServiceImpl;
import general.Callback_App_receive;
import general.Message;
//import ice.db.MsgMapHelper;
import ice.servant.TomI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 收到接收消息回调
 */
public class Callback_App_receiveI extends Callback_App_receive {
    private Logger logger = LoggerFactory.getLogger(Callback_App_receiveI.class);
    private MessageService messageService = new MessageServiceImpl();
    @Override
    public void response() {


        System.out.println("消息发到app");

        try {
            messageService.removeMessage(msg.toUserId);
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }


    public Callback_App_receiveI( Message msg){
        this.msg = msg;

    }

    private Message msg = null;


    @Override
    public void exception(LocalException e) {
        System.out.println("消息发到app失败："+msg.msg);
        //让客户端下线
        TomI._clients.remove(msg.toUserId);
        messageService.saveMessage(msg);
        logger.info(e.getMessage());
    }
}
