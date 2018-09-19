package ru.innopolis.stc13.hw8_chat;

import ru.innopolis.stc13.sockets.Server;

import java.io.*;
import java.net.Socket;

public class Client {

    private boolean running;

    public static void main(String[] args) {
        new Client().start();
    }

    public void start() {

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             Socket socket = new Socket("127.0.0.1", Server.SERVER_PORT);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("enter your name");
            writer.write(consoleReader.readLine());
            writer.newLine();
            writer.flush();
            while (reader.readLine().equals("n")) {
                System.out.println("name already taken, try again");
                writer.write(consoleReader.readLine());
                writer.newLine();
                writer.flush();
            }
            running = true;
            System.out.println("you're online");
            new Thread(() -> {
                String message;
                try {
                    while (running && (message = reader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String message;
            while (true) {
                message = consoleReader.readLine();
                writer.write(message);
                writer.newLine();
                writer.flush();
                if (message.equals("exit")) {
                    break;
                }
            }
            running = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
