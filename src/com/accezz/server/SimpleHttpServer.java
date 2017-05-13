package com.accezz.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class Java_HttpServer {
 
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
            httpServer.createContext("/", new MyHttpHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException ex) {
            Logger.getLogger(Java_HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    static class MyHttpHandler implements HttpHandler{
 
        @Override
        public void handle(HttpExchange he) throws IOException {
            int responseCode_OK = 200;
            String response = "Hello from java-buddy";
            he.sendResponseHeaders(responseCode_OK, response.length());
             
            OutputStream outputStream = he.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
             
            //try-with-resources form
            /*
            try (OutputStream outputStream = he.getResponseBody()) {
                outputStream.write(response.getBytes());
            }
            */
 
        }
         
    }
     
}

