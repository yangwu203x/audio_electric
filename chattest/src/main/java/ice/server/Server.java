package ice.server;
// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// **********************************************************************


import ice.servant.TomI;

public class Server extends Ice.Application
{
    private static Server server = null;
    public static Server getInstance(){
        if (server == null){
            server = new Server();
        }
        return server;
    }

    @Override
    public int
    run(String[] args)
    {
        Ice.Communicator ic = Ice.Util.initialize();
        Ice.ObjectAdapter adapter = communicator().createObjectAdapter("tom");
        TomI sender = new TomI(communicator());
        adapter.add(sender, communicator().stringToIdentity("tom"));
        adapter.activate();
        //new MsgMapHelper(communicator());

        try
        {
            communicator().waitForShutdown();
        }
        finally
        {

        }

        return 0;
    }

}
