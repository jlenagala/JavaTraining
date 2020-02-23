package com.janani;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {
        System.out.println("Server!");
        int port = 1111;
        Server server=new Server(port);
        server.start();
    }


}
