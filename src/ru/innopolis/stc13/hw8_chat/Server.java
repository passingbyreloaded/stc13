package ru.innopolis.stc13.hw8_chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    public static final Integer SERVER_PORT = 4999;

    private boolean running;
    private Map<Socket, String> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {

        new Server().start();
    }

    public void start() throws IOException {
        running = true;
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("im on");
        while (running) {
            Socket socket = serverSocket.accept();
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String name;
                while (clients.containsValue(name = reader.readLine())) {
                    writer.write("n");
                    writer.newLine();
                    writer.flush();
                }
                writer.write("y");
                writer.newLine();
                writer.flush();
                System.out.println(name + " is connected");
                clients.put(socket, name);

                new Thread(() -> {
                    String message;
                    try (BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                        while ((message = clientReader.readLine()) != null) {
                            if (message.equals("exit")) {
                                Server.this.broadcast(clients.get(socket) + " is out");
                                break;
                            } else {
                                Server.this.broadcast(clients.get(socket) + ": " + message);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcast(String message) {
        System.out.println("broadcasting");
        for (Map.Entry<Socket, String> entry : clients.entrySet()) {
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(entry.getKey().getOutputStream()));
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;
    }
}
