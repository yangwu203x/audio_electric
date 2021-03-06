package ice.listener;

import com.audio.electric.util.AppUtils;
import ice.server.Server;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class IceServer implements ServletContextListener {


    // Public constructor is required by servlet spec
    public IceServer() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

        Thread t =  new Thread (new Runnable() {
            public void run() {
                Server app = new Server();
                 app.main("Server", new String[]{}, AppUtils.AppPath+"/config/config.server");

            }
        });
        t.start();
        System.out.println(t.getId());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        Server.communicator().destroy();
    }


}
