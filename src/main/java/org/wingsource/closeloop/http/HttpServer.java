package org.wingsource.closeloop.http;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerServer;
import org.simpleframework.transport.Server;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;
import org.wingsource.closeloop.EventLoopThread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Created by sa on 16-06-2014.
 */
public class HttpServer {

    public static void create(String port,ScriptObjectMirror callback) throws IOException {
        EventLoopThread.getInstance().execute(new HttpThread(port,callback));
    }
    
    public static class HttpThread implements Runnable {

        private ScriptObjectMirror callback;
        private String port;

        public HttpThread(String port,ScriptObjectMirror cb) {
            this.callback = cb;
            this.port = port;
        }

        @Override
        public void run() {
            Container container = new Container() {
                @Override
                public void handle(Request request, Response response) {
                    callback.callMember("func",request,response);
                }
            };
            Server server = null;
            try {
                server = new ContainerServer(container);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Connection connection = null;
            try {
                connection = new SocketConnection(server);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SocketAddress address = new InetSocketAddress(Integer.parseInt(port));
            if (connection != null) {
                try {
                    connection.connect(address);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
