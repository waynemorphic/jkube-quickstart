package org.jkubequickstart;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Handler implements HttpHandler {
    private static final Logger log = Logger.getLogger(App.class.getSimpleName());

    @Override
    public void handle(HttpExchange exchange) {
        try (OutputStream stream = exchange.getResponseBody()){
            log.log(Level.INFO, ()-> "GET /hello");
            String response = "Hello world";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            stream.write(response.getBytes());
            log.log(Level.INFO, ()-> "Response written successfully: " + response);
        }
        catch (IOException e){
            log.log(Level.SEVERE, ()-> "Server failed to respond" + e.getMessage());
        }
    }
}