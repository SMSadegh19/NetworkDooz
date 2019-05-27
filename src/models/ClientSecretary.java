package models;

import view.packets.RequestPacket;
import view.packets.requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSecretary {
    private Socket socket;
    private Player player;

    public ClientSecretary(Socket socket) {
        this.socket = socket;
    }

    public void startWorking() throws IOException {
        Scanner scanner = new Scanner(socket.getInputStream());
        CommandListener listenerThread = new CommandListener(scanner, this);
        listenerThread.start();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void respondToRequest(RequestPacket requestPacket) {
        Request request = requestPacket.getRequest();
        request.respondToRequest(this);
    }

    // TODO: 5/27/19
}
