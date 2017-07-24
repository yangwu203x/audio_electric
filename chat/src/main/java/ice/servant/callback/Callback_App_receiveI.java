package ice.servant.callback;

import Ice.LocalException;
import com.audio.electric.service.MessageService;
import com.audio.electric.util.ApplicationContextUtil;
import general.Callback_App_receive;
import general.Message;
import ice.servant.TomI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 收到接收消息回调
 */
public class Callback_App_receiveI extends Callback_App_receive {
    private Message msg = null;
    private Logger logger = LoggerFactory.getLogger(Callback_App_receiveI.class);
    private MessageService messageService = (MessageService) ApplicationContextUtil.getBean(MessageService.class);
    /**
     * 构造函数
     * @param msg
     */
    public Callback_App_receiveI( Message msg){ this.msg = msg;}

    /**
     * 发送成功回掉函数
     */
    @Override
    public void response() {
        logger.info("消息发到app");
        messageService.removeMessage(msg.toUserId);
    }

    /**
     * 发送失败回掉函数
     * @param e
     */
    @Override
    public void exception(LocalException e) {
        //让客户端下线
        TomI._clients.remove(msg.toUserId);
        logger.info("消息发到app失败，原因" + e.getMessage());
    }
}
