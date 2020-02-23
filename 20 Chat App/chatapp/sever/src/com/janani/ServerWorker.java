package com.janani;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerWorker extends Thread {
    //Create a new thread everytime when connect a client and keep free main thread to accept a new client
    private final Socket clientSocket;
    private final Server server;
    private String connection = null;
    private OutputStream outputStream;
    private String conName=null;

    public ServerWorker(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    private void handleClientSocket() throws IOException, InterruptedException {
        //for reading data
        InputStream inputStream = clientSocket.getInputStream();
        //get data from client
        this.outputStream = clientSocket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] input = line.split(" ");
            if (input != null && input.length > 0) {
                String command = input[0];
                if ("exit".equalsIgnoreCase(command)) {
//                    String msg = "Exit the connection " + "\n";
//                    outputStream.write(msg.getBytes());
                    handlelogoff(outputStream, input);
                    break;
                } else if ("connect".equalsIgnoreCase(command)) {
                    handleConnect(outputStream, input);
                }
                else if ("send".equalsIgnoreCase(command)){
                    String[] inputMsg=line.split(" ",3);
                    handleMessage(inputMsg);

                }
                else {
                    String msg = "unknown " + command + "\n";
                    outputStream.write(msg.getBytes());
                }


            }

        }

        clientSocket.close();
    }

    private void handleMessage(String[] input) throws IOException {
        String sendTo=input[1];
        String body=input[2];
        ArrayList<ServerWorker> workerArrayList = server.getWorkerArrayList();
        for (ServerWorker worker : workerArrayList) {
            if(sendTo.equalsIgnoreCase(worker.getConName())){
                String outMsg="send "+conName+" "+ body + "\n";
                worker.send(outMsg);
            }
    }}

    private void handlelogoff(OutputStream outputStream, String[] input) throws IOException {
        server.removeWorker(this);
        ArrayList<ServerWorker> workerArrayList = server.getWorkerArrayList();

        String onlineMsg = "exit " + connection + "\n";
        for (ServerWorker worker : workerArrayList) {
            if (!connection.equals(worker.getConnection())) {
                worker.send(onlineMsg);
            }
        }
        clientSocket.close();
    }

    public String getConnection() {
        return connection;
    }

    private void handleConnect(OutputStream outputStream, String[] input) throws IOException {

        if (input.length == 4) {
            String id = input[1];
            String port = input[2];
            String name = input[3];
            if ("localhost".equalsIgnoreCase(id)) {
                String msg = "connected " + name + "\n";
                outputStream.write(msg.getBytes());
                this.connection = port;
                this.conName=name;
                System.out.println("User Connected Succsesfully " + connection);

                ArrayList<ServerWorker> workerArrayList = server.getWorkerArrayList();
                //Send current user all other online logins
                for (ServerWorker worker : workerArrayList) {

                    if (worker.getConnection() != null) {
                        if (!connection.equals(worker.getConnection())) {
                            String msg2 = "Onlinedsadsad " + worker.getConnection() + "\n";
                            send(msg2);
                        }

                    }
                }
                //send other online users
                String onlineMsg = "Online " + connection + "\n";
                for (ServerWorker worker : workerArrayList) {
                    if (!connection.equals(worker.getConnection())) {
                        worker.send(onlineMsg);
                    }
                }

            } else {
                String msg = "Connection Error " + "\n";
                outputStream.write(msg.getBytes());
            }
        }
    }

    private void send(String msg) throws IOException {
        if (connection != null) {
            outputStream.write(msg.getBytes());
        }

    }

    @Override
    public void run() {

        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getConName() {
        return conName;
    }


}
