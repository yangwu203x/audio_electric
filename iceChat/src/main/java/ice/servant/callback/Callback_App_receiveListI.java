package ice.servant.callback;

import Ice.LocalException;
import com.audio.electric.service.MessageService;
import com.audio.electric.service.impl.MessageServiceImpl;
import general.Callback_App_receiveList;
import general.Message;
//import ice.db.MsgMapHelper;
import ice.servant.TomI;

/**
 */
public class Callback_App_receiveListI extends Callback_App_receiveList {
    private MessageService messageService = new MessageServiceImpl();
    @Override
    public void response() {
        System.out.println("消息发到app成功List");
        //MsgMapHelper.getMsgMap().remove(msgs[0].toUserId);
        messageService.removeMessage(msgs[0].toUserId);
    }


    public Callback_App_receiveListI(Message[] msgs ){
       this.msgs = msgs;
    }
    private Message[] msgs = null;


    @Override
    public void exception(LocalException e) {
        System.out.println("消息发到app失败List");
        //MsgMapHelper.add(msgs);
        messageService.saveMessage(msgs);
        messageService.removeMessage(msgs[0].toUserId);
        // TomI._clients.remove(msgs[0].toUserId);
        e.printStackTrace();
    }
}
