import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ChatClient {
    private static String name;
    private static String serverUrl;
    private static boolean isConnected = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Thread.sleep(1000);
                String line = scanner.nextLine();
                //connect localhost:1111 as jan
                String[] input = line.split(" ");
                String cmd = input[0];

                if (cmd.equals("connect")) {
                    serverUrl = input[1];
                    name = input[3];
                    sendConnect();
                }
                if (cmd.equals("list") && isConnected) {
                    sendList();
                } else if (cmd.matches("send ") && isConnected) {
                    String[] msg = line.split(" ", 3);
                    sendMessage(msg[2], msg[1]);
                } else if (cmd.equals("exit") && isConnected) {
                    if (isConnected)
                        sendLogoff();
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static void sendConnect() throws IOException {
        if (!isConnected) {
            URL url = new URL("http://" + serverUrl + "/connect");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(name);
            bufferedWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = bufferedReader.readLine();
            if (line.equals("Already Reg")) {
                name = null;
                isConnected = false;
                System.out.println("Already Registered");
            } else {
                isConnected = true;
                System.out.println("Connected");
                new MessageChecker().start();
            }

        }
    }

    private static void sendList() throws IOException {

        URL url = new URL("http://" + serverUrl + "/list");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
        bufferedWriter.write(name);
        bufferedWriter.close();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String s = bufferedReader.readLine();
        if (s.isEmpty())
            System.out.println("No Users");
        else
            System.out.print(s.replaceAll(" ", System.lineSeparator()));

    }

    private static void sendMessage(String message, String toUser) {

        try {
            URL url = new URL("http://" + serverUrl + "/send");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.write(toUser);
            bufferedWriter.newLine();
            bufferedWriter.write(message);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String s = bufferedReader.readLine();
            if ("no".equals(s)) {
                System.out.println("No such user");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendLogoff() {
        try {
            URL url = new URL("http://" + serverUrl + "/logoff");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(name);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String s = bufferedReader.readLine();
            System.out.println(s);
            if (s.equals("Disconnected")) {
                isConnected = false;
                name = null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MessageChecker extends Thread {

        public void run() {
            while (isConnected) {
                try {
                    URL url = new URL("http://" + serverUrl + "/receive");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
                    bufferedWriter.write(name);
                    bufferedWriter.close();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String s = bufferedReader.readLine();
                    if (!s.equals("no message")) {

                    }

                } catch (Exception e) {
                }
            }
        }
    }
}
