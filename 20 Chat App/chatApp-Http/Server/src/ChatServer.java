import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {

    static Map<String, ArrayList<String>> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(1111), 0);
//        HttpContext context = server.createContext("/");
        HttpContext contextConnect = server.createContext("/connect");
        HttpContext contextList = server.createContext("/list");
        HttpContext contextLogoff = server.createContext("/logoff");
        HttpContext contextSend = server.createContext("/send");
        HttpContext contextRecieve = server.createContext("/receive");

//        context.setHandler(ChatServer::handleRequest);
        contextConnect.setHandler(ChatServer::handleConnect);
        contextList.setHandler(ChatServer::handleList);
        contextLogoff.setHandler(ChatServer::handleLogoff);
        contextSend.setHandler(ChatServer::handleSend);
        contextRecieve.setHandler(ChatServer::handleRecieve);


        server.start();
    }

    private static void handleConnect(HttpExchange httpExchange) throws IOException {

        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        String name = bufferedReader.readLine();
        bufferedReader.close();
        String response = "Connected " + name;
        if (users.containsKey(name))
            response = "Already Reg";
        else
            users.put(name, null);
        httpExchange.sendResponseHeaders(200, response.length());
        bufferedWriter.write(response);
        bufferedWriter.close();
    }

    private static void handleRecieve(HttpExchange httpExchange) throws IOException {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        String name = bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<String> strings = users.get(name);

        String ss = "";
        if(strings ==null || strings.isEmpty()){
            ss = "no message";
        }else{
            for (String s : strings) {
                ss +=  strings+ " ";
            }
            System.out.println(strings.size()+name);
        }



        users.put(name,null);

        httpExchange.sendResponseHeaders(200, ss.length());
        bufferedWriter.write(ss);
        bufferedWriter.close();
        httpExchange.close();
    }

    private static void handleSend(HttpExchange httpExchange) {
        System.out.println("hi");
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String name = bufferedReader.readLine();
            String to = bufferedReader.readLine();
            String message = bufferedReader.readLine();
            bufferedReader.close();
            String response = "";
            System.out.println(to+to.length());
            if (users.containsKey(to)) {
                ArrayList<String> stringArrayList = users.get(to);
                if (stringArrayList == null) {
                    stringArrayList = new ArrayList<>();
                    users.put(to, stringArrayList);
                }
                stringArrayList.add(name + " " + message);
                System.out.println(to);
                System.out.println(name+ " "+message);
            } else {
                response = "null";
            }
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleLogoff(HttpExchange httpExchange) {

        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();
            String response = "No User";
            if (users.containsKey(name)) {
                users.remove(name);
                response = "Logoff";
            }
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleList(HttpExchange httpExchange) throws IOException {

        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

        String name = bufferedReader.readLine();
        bufferedReader.close();

        String ss = "";
        for (String s : users.keySet()) {
            System.out.println(s);
            if (!name.equals(s)) {
                ss += s + " ";
            }


        }
        httpExchange.sendResponseHeaders(200, ss.length());
        bufferedWriter.write(ss);
        bufferedWriter.close();

        httpExchange.close();
    }

//    private static void handleRequest(HttpExchange httpExchange) throws IOException {
//        String response = "Hi there!";
//        httpExchange.sendResponseHeaders(200, response.getBytes().length);
//        OutputStream outputStream = httpExchange.getResponseBody();
//        outputStream.write(response.getBytes());
//        outputStream.close();
//    }
}