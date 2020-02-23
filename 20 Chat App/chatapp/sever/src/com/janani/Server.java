package com.janani;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private final int serverPort;
    private ArrayList<ServerWorker> workerArrayList= new ArrayList<>();

    public Server(int serverPort) {
        this.serverPort = serverPort;
    }

    public ArrayList<ServerWorker> getWorkerArrayList() {
        return workerArrayList;
    }


    @Override
    public void run() {
        try {
            // create connection between server and client
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerWorker serverWorker = new ServerWorker(this,clientSocket);
                workerArrayList.add(serverWorker);
                serverWorker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeWorker(ServerWorker serverWorker) {
        workerArrayList.remove(serverWorker);
    }
}
