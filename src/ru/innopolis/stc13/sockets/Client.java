package ru.innopolis.stc13.sockets;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", Server.SERVER_PORT);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            new Thread() {
                @Override
                public void run() {
                    String message;
                    try {
                        while ((message = reader.readLine()) != null) {
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            Scanner scanner = new Scanner(System.in);
            String message;
            while (!(message = scanner.nextLine()).equals("")) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
