package models;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private Socket socket;
    private Player player;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        Scanner scanner = new Scanner(socket.getInputStream());
        CommandListener listener = new CommandListener(scanner);
        listener.start();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // TODO: 5/27/19
}
