package ice.servant.callback;

import Ice.LocalException;
import com.audio.electric.service.MessageService;
import com.audio.electric.util.ApplicationContextUtil;
import general.Callback_App_receiveList;
import general.Message;
import ice.servant.TomI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 上线时获取消息集合回掉函数
 */
public class Callback_App_receiveListI extends Callback_App_receiveList {
    private Message[] msgs = null;
    private static final Logger logger = LoggerFactory.getLogger(Callback_App_receiveListI.class);
    private MessageService messageService = (MessageService) ApplicationContextUtil.getBean(MessageService.class);

    /**
     * 构造函数
     * @param msgs
     */
    public Callback_App_receiveListI(Message[] msgs ){this.msgs = msgs;    }

    /**
     * 发送成功回掉函数
     */
    @Override
    public void response() {
        logger.info("消息发到app成功List");
        messageService.removeMessage(msgs[0].toUserId);
    }

    /**
     * 发送失败回掉函数
     * @param e
     */
    @Override
    public void exception(LocalException e) {
        logger.info("消息发到app失败List，原因"+e.getMessage());
        TomI._clients.remove(msgs[0].toUserId);
    }
}
