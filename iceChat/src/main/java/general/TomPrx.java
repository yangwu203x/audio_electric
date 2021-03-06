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

public interface TomPrx extends Ice.ObjectPrx
{
    public void addClient(Ice.Identity ident, String userId);

    public void addClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident, String userId);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident, String userId, Ice.Callback __cb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident, String userId, Callback_Tom_addClient __cb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx, Callback_Tom_addClient __cb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident,
                                           String userId,
                                           IceInternal.Functional_VoidCallback __responseCb,
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident,
                                           String userId,
                                           IceInternal.Functional_VoidCallback __responseCb,
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                           IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident,
                                           String userId,
                                           java.util.Map<String, String> __ctx,
                                           IceInternal.Functional_VoidCallback __responseCb,
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_addClient(Ice.Identity ident,
                                           String userId,
                                           java.util.Map<String, String> __ctx,
                                           IceInternal.Functional_VoidCallback __responseCb,
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                           IceInternal.Functional_BoolCallback __sentCb);

    public void end_addClient(Ice.AsyncResult __result);

    public void addMsg(Ice.Identity ident, Message msg);

    public void addMsg(Ice.Identity ident, Message msg, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident, Message msg);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident, Message msg, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident, Message msg, Ice.Callback __cb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident, Message msg, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident, Message msg, Callback_Tom_addMsg __cb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident, Message msg, java.util.Map<String, String> __ctx, Callback_Tom_addMsg __cb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident,
                                        Message msg,
                                        IceInternal.Functional_VoidCallback __responseCb,
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident,
                                        Message msg,
                                        IceInternal.Functional_VoidCallback __responseCb,
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                        IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident,
                                        Message msg,
                                        java.util.Map<String, String> __ctx,
                                        IceInternal.Functional_VoidCallback __responseCb,
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_addMsg(Ice.Identity ident,
                                        Message msg,
                                        java.util.Map<String, String> __ctx,
                                        IceInternal.Functional_VoidCallback __responseCb,
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                        IceInternal.Functional_BoolCallback __sentCb);

    public void end_addMsg(Ice.AsyncResult __result);

    public void logoutClient(Ice.Identity ident, String userId);

    public void logoutClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident, String userId);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident, String userId, Ice.Callback __cb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident, String userId, Callback_Tom_logoutClient __cb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident, String userId, java.util.Map<String, String> __ctx, Callback_Tom_logoutClient __cb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident,
                                              String userId,
                                              IceInternal.Functional_VoidCallback __responseCb,
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident,
                                              String userId,
                                              IceInternal.Functional_VoidCallback __responseCb,
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                              IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident,
                                              String userId,
                                              java.util.Map<String, String> __ctx,
                                              IceInternal.Functional_VoidCallback __responseCb,
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_logoutClient(Ice.Identity ident,
                                              String userId,
                                              java.util.Map<String, String> __ctx,
                                              IceInternal.Functional_VoidCallback __responseCb,
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb,
                                              IceInternal.Functional_BoolCallback __sentCb);

    public void end_logoutClient(Ice.AsyncResult __result);
}
