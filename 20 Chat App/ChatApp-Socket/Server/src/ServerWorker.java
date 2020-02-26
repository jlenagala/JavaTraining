import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ServerWorker extends Thread {

    private static final HashMap<String, ServerWorker> workers = new HashMap<>();

    //Create a new thread everytime when connect a client and keep free main thread to accept a new client
    private final Socket clientSocket;
    private final Server server;
    private String connection = null;
    private OutputStream outputStream;
    private String conName = null;

    public ServerWorker(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    private void handleClientSocket() throws IOException {
        //for reading data
        InputStream inputStream = clientSocket.getInputStream();
        //get data from client
        this.outputStream = clientSocket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));

        String line;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            line = bufferedReader.readLine();

            if (line != null) {

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
                    } else if ("send".equalsIgnoreCase(command)) {
                        String[] inputMsg = line.split(" ", 3);
                        handleMessage(inputMsg);

                    } else if ("list".equalsIgnoreCase(command)) {

                        handleList();
                    } else {
                        String msg = "unknown " + command + "\n";
                        outputStream.write(msg.getBytes());
                    }


                }
            }

        }

        clientSocket.close();
    }

    private void handleList() throws IOException {
        String ss = "";
        for (String s : workers.keySet()) {
            System.out.println(s);
            if (!conName.equals(s)) {
                ss += s + " ";
                System.out.println(ss);
                send(ss);

            }
        }


/*        try {
            System.out.println(ss);
            ServerWorker serverWorker = workers.get(conName);
            serverWorker.send(ss);
            System.out.println(clientSocket.getPort());
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    private void handleMessage(String[] input) throws IOException {
        String sendTo = input[1];
        String body = input[2];
        ServerWorker serverWorker = workers.get(sendTo);
//        ArrayList<ServerWorker> workerArrayList = server.getWorkerArrayList();
//        for (ServerWorker worker : workerArrayList) {
//            if(sendTo.equalsIgnoreCase(worker.getConName())){
        String outMsg = "send " + conName + " " + body + "\n";
        serverWorker.send(outMsg);
//            }
//        }
    }

    private void handlelogoff(OutputStream outputStream, String[] input) throws IOException {
//        server.removeWorker(this);
//        ArrayList<ServerWorker> workerArrayList = server.getWorkerArrayList();
//
//        String onlineMsg = "exit " + connection + "\n";
//        for (ServerWorker worker : workerArrayList) {
//            if (!connection.equals(worker.getConnection())) {
//
//
//                worker.send(onlineMsg);
//            }
//        }
//        clientSocket.close();
    }

    public String getConnection() {
        return connection;
    }

    private void handleConnect(OutputStream outputStream, String[] input) throws IOException {

        if (input.length == 4) {
            String ip = input[1];
            String port = input[2];
            String name = input[3];
//            if ("localhost".equalsIgnoreCase(ip)) {
            String msg = "connected " + name + "\n";
            outputStream.write(msg.getBytes());
            this.connection = port;
            this.conName = name;
            System.out.println("User " + name + " Connected Succsesfully " + connection);

            workers.put(name, this);


//                ArrayList<ServerWorker> workerArrayList = server.getWorkerArrayList();
            //Send current user all other online logins
                /*for (ServerWorker worker : workerArrayList) {

                    if (worker.getConnection() != null) {
                        if (!connection.equals(worker.getConnection())) {
                            String msg2 = "Onlinedsadsad " + worker.getConnection() + "\n";
                            send(msg2);
                        }

                    }
                }*/
            //send other online users
//                String onlineMsg = "Online " + connection + "\n";
//                for (ServerWorker worker : workerArrayList) {
//                    if (!connection.equals(worker.getConnection())) {
//                        worker.send(onlineMsg);
//                    }
//                }

//            } else {
//                String msg = "Connection Error " + "\n";
//                outputStream.write(msg.getBytes());
//            }
        }
    }

    private void send(String msg) throws IOException {
        if (connection != null) {
            outputStream.write(msg.getBytes());
            outputStream.flush();
        } else {
            System.out.println("connection null");
        }

    }

    @Override
    public void run() {

        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getConName() {
        return conName;
    }


}