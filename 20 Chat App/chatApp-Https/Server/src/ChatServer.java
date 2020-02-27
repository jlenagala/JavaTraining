import com.sun.net.httpserver.*;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {

    static Map<String, ArrayList<String>> users = new HashMap<>();

    public static void main(String[] args) {
        try {

            System.setProperty("javax.net.debug","all");
            FileInputStream fileInputStream = new FileInputStream("/home/user/Downloads/JavaTraining - SpringBoot/chatApp26/ChatApp-Https/SSL/Keys/DebKeyStore.jks");
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(fileInputStream, "123456".toCharArray());

            KeyManagerFactory key = KeyManagerFactory.getInstance("SunX509");
            key.init(keystore, "123456".toCharArray());

            TrustManagerFactory trust = TrustManagerFactory.getInstance("SunX509");
            trust.init(keystore);

            HttpsServer server = HttpsServer.create(new InetSocketAddress(1111), 0);
            SSLContext context = SSLContext.getInstance("TLS");

            context.init(key.getKeyManagers(), trust.getTrustManagers(), null);

            server.setHttpsConfigurator(new HttpsConfigurator(context) {
                @Override
                public void configure(HttpsParameters httpsParameters) {
                    SSLContext sslContext = getSSLContext();
                    SSLEngine sslEngine = sslContext.createSSLEngine();
                    httpsParameters.setNeedClientAuth(false);
                    httpsParameters.setCipherSuites(sslEngine.getEnabledCipherSuites());
                    httpsParameters.setProtocols(sslEngine.getEnabledProtocols());
                    SSLParameters defaultSSLParameters = sslContext.getSupportedSSLParameters();
                    httpsParameters.setSSLParameters(defaultSSLParameters);
                }
            });

            HttpContext contextHi = server.createContext("/");
            HttpContext contextConnect = server.createContext("/connect");
            HttpContext contextList = server.createContext("/list");
            HttpContext contextLogoff = server.createContext("/logoff");
            HttpContext contextSend = server.createContext("/send");
            HttpContext contextRecieve = server.createContext("/receive");

            contextHi.setHandler(ChatServer::handleRequest);
            contextConnect.setHandler(ChatServer::handleConnect);
            contextList.setHandler(ChatServer::handleList);
            contextLogoff.setHandler(ChatServer::handleLogoff);
            contextSend.setHandler(ChatServer::handleSend);
            contextRecieve.setHandler(ChatServer::handleRecieve);
            server.start();
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

        private static void handleConnect (HttpExchange httpExchange) throws IOException {

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

        private static void handleRecieve (HttpExchange httpExchange) throws IOException {
            InputStream requestBody = httpExchange.getRequestBody();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
            OutputStream responseBody = httpExchange.getResponseBody();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));

            String name = bufferedReader.readLine();
            bufferedReader.close();

            ArrayList<String> strings = users.get(name);

            String ss = "";
            if (strings == null || strings.isEmpty()) {
                ss = "no message";
            } else {
                for (String s : strings) {
                    ss += strings + " ";
                }
            }
            users.put(name, null);

            httpExchange.sendResponseHeaders(200, ss.length());
            bufferedWriter.write(ss);
            bufferedWriter.close();
            httpExchange.close();
        }

        private static void handleSend (HttpExchange httpExchange){
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
                if (users.containsKey(to)) {
                    ArrayList<String> stringArrayList = users.get(to);
                    if (stringArrayList == null) {
                        stringArrayList = new ArrayList<>();
                        users.put(to, stringArrayList);
                    }
                    stringArrayList.add(name + " " + message);
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

        private static void handleLogoff (HttpExchange httpExchange){

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

        private static void handleList (HttpExchange httpExchange) throws IOException {

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

        private static void handleRequest (HttpExchange httpExchange) throws IOException {
            String response = "Hi there!";
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
