// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `Callback.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package general;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public class Message implements Cloneable, java.io.Serializable
{
    public String msgId;//消息id

    public String msg;//消息描述

    public String srcUserId;//发送者id

    public String toUserId;//接受者id

    public String context;//消息内容

    public String status;//消息状态0：未读取，1：已读取

    public Message()
    {
        msg = "";
        srcUserId = "";
        toUserId = "";
        msgId = "";
        context = "";
        status = "0";
    }

    public Message(String msg, String srcUserId, String toUserId, String msgId, String context, String status)
    {
        this.msg = msg;
        this.srcUserId = srcUserId;
        this.toUserId = toUserId;
        this.msgId = msgId;
        this.context = context;
        this.status = status;
    }

    public boolean
    equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Message _r = null;
        if(rhs instanceof Message)
        {
            _r = (Message)rhs;
        }

        if(_r != null)
        {
            if(msg != _r.msg)
            {
                if(msg == null || _r.msg == null || !msg.equals(_r.msg))
                {
                    return false;
                }
            }
            if(srcUserId != _r.srcUserId)
            {
                if(srcUserId == null || _r.srcUserId == null || !srcUserId.equals(_r.srcUserId))
                {
                    return false;
                }
            }
            if(toUserId != _r.toUserId)
            {
                if(toUserId == null || _r.toUserId == null || !toUserId.equals(_r.toUserId))
                {
                    return false;
                }
            }
            if(msgId != _r.msgId)
            {
                if(msgId == null || _r.msgId == null || !msgId.equals(_r.msgId))
                {
                    return false;
                }
            }
            if(context != _r.context)
            {
                if(context == null || _r.context == null || !context.equals(_r.context))
                {
                    return false;
                }
            }

            if(status != _r.status)
            {
                if(status == null || _r.status == null || !status.equals(_r.status))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::Demo::Message");
        __h = IceInternal.HashUtil.hashAdd(__h, msg);
        __h = IceInternal.HashUtil.hashAdd(__h, srcUserId);
        __h = IceInternal.HashUtil.hashAdd(__h, toUserId);
        __h = IceInternal.HashUtil.hashAdd(__h, msgId);
        __h = IceInternal.HashUtil.hashAdd(__h, context);
        __h = IceInternal.HashUtil.hashAdd(__h, status);
        return __h;
    }

    public Message
    clone()
    {
        Message c = null;
        try
        {
            c = (Message)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(msg);
        __os.writeString(srcUserId);
        __os.writeString(toUserId);
        __os.writeString(msgId);
        __os.writeString(context);
        __os.writeString(status);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        msg = __is.readString();
        srcUserId = __is.readString();
        toUserId = __is.readString();
        msgId = __is.readString();
        context = __is.readString();
        status = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, Message __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public Message
    __read(IceInternal.BasicStream __is, Message __v)
    {
        if(__v == null)
        {
             __v = new Message();
        }
        __v.__read(__is);
        return __v;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", srcUserId='" + srcUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", msgId='" + msgId + '\'' +
                ", context='" + context + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    private static final Message __nullMarshalValue = new Message();

    public static final long serialVersionUID = -1460735249L;
}