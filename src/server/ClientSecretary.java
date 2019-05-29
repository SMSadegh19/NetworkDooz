package server;

import com.gilecode.yagson.YaGson;
import packets.RequestPacket;
import packets.UpdatePacket;
import packets.requests.Request;
import models.Player;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSecretary {
    private Socket socket;
    private Player player;
    private PrintStream printStream;

    public ClientSecretary(Socket socket) throws IOException {
        this.socket = socket;
        this.printStream = new PrintStream(socket.getOutputStream());
    }

    public void startConnection() throws IOException {
        Scanner scanner = new Scanner(socket.getInputStream());
        ServerListener listenerThread = new ServerListener(scanner, this);
        listenerThread.start();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    //  //\\\\////\\\\////\\\\////  \\
    //  \\////\\\\////\\\\////\\\\  \\
    //  //\\\\////\\\\////\\\\////  \\
    //  \\////\\\\////\\\\////\\\\  \\

    public void respondToRequest(RequestPacket requestPacket) {
        Request request = requestPacket.getRequest();
        request.respondToRequest(this);
    }

    public void updateClient(UpdatePacket updatePacket) {
        String updatePacketJson = new YaGson().toJson(updatePacket);
        printStream.println(updatePacketJson);
        printStream.flush();
    }

    // TODO: 5/27/19
}
