package com.janani;

import java.io.*;
import java.net.Socket;

public class Main {
    private static OutputStream outputStream;

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 1111);
        //for reading data
        InputStream inputStream = clientSocket.getInputStream();
        /* get data from client */
        outputStream = clientSocket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        String line;

        while ((line = bufferedReader.readLine()) != null) {

            String[] input = line.split(" ");
            if (input != null && input.length > 0) {
                String command = input[0];


            }

        }

        clientSocket.close();


    }
}
