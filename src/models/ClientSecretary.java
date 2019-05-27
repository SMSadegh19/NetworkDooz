package models;

import com.gilecode.yagson.YaGson;
import view.packets.RequestPacket;
import view.packets.UpdatePacket;
import view.packets.requests.Request;

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

    public void startWorking() throws IOException {
        Scanner scanner = new Scanner(socket.getInputStream());
        CommandListener listenerThread = new CommandListener(scanner, this);
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

    // TODO: 5/27/19
}
