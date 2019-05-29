package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DoozServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            System.out.println("Server is waiting for new client...");
            Socket socket = serverSocket.accept();
            ClientSecretary newClientSecretary = new ClientSecretary(socket);
            ServerContents.addClientSecretary(newClientSecretary);
            newClientSecretary.startConnection();
        }
    }
}
