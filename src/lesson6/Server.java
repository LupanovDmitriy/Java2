package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        final int PORT = 8189;
        DataInputStream in;
        DataOutputStream out;
        Scanner sc =new Scanner(System.in);


        try(ServerSocket Server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен");
            try(Socket socket = Server.accept()) {
                System.out.println("Клиент подключился");
                //Scanner in =new Scanner(socket.getInputStream());
                in =new DataInputStream(socket.getInputStream());

                //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out  = new DataOutputStream(socket.getOutputStream());

                new Thread(() -> {
                    try {
                        while (true) {
                            out.writeUTF(sc.nextLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();


                while(true){
                    String str= in.readUTF();

                    if(str.equals("/end")){
                        out.writeUTF("Сервер завершил работу");
                        break;

                    }
                    System.out.println("Клиент:"+str);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
