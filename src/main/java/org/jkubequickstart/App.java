package org.jkubequickstart;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.sun.net.httpserver.HttpServer;

public class App {
    private static final Logger log = Logger.getLogger(App.class.getSimpleName());
    private static int port = 8081;

     public static void main(String[] args) {
         try{
             HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
             server.createContext("/hello", new Handler());
             server.setExecutor(null);
             server.start();
             log.log(Level.INFO, ()-> "Server started on port: " + port);
         }catch(IOException e){
             log.log(Level.SEVERE,()->"Error occurred when starting server" + e.getMessage());
         }
    }
}
