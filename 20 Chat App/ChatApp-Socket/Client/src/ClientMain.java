import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

   static Socket socket = null;
   static PrintWriter printWriter = null;
   static BufferedReader bufferedReader = null;
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);

            String s = scanner.nextLine();

            String[] s1 = s.split(" ");
            String ip = s1[1];
            int port =Integer.parseInt(s1[2]);
            String name = s1[3];

            try {
                socket = new Socket(ip, port);
                printWriter = new PrintWriter(socket.getOutputStream(), true);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
            catch (IOException e) {
                return;
            }
            printWriter.println("connect "+ip+" "+port+" "+name);

            String input;
            new Thread(()->{

                while (true){

                    try {
                        System.out.println(bufferedReader.readLine());
                    } catch (IOException e) {
                        break;
                    }
                }

            }).start();

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                input = scanner.nextLine();

                if(input!=null) {
                    if (input.equals("exit"))
                        break;
                    printWriter.println(input);
                }
            }

            printWriter.close();
            bufferedReader.close();
            socket.close();


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}