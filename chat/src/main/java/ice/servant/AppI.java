package ice.servant;// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// **********************************************************************

import Ice.Current;
import general.Message;
import general._AppDisp;

public  class AppI extends _AppDisp
{

    public void receive( Message msg, Current __current) {

        //收到消息的逻辑
        System.out.println("receive方法：app收到消息："+msg);
    }

    public void receiveList( Message[] msgs, Current __current) {
        for (Message msg : msgs){
            //收到消息的逻辑
            System.out.println("receiveList方法：app收到消息："+msg);
        }
    }


}
