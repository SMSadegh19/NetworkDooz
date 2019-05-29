package server;

import com.gilecode.yagson.YaGson;
import packets.RequestPacket;

import java.util.Scanner;

public class ServerListener extends Thread {
    private Scanner scanner;
    private ClientSecretary clientSecretary;

    public ServerListener(Scanner scanner, ClientSecretary clientSecretary) {
        this.scanner = scanner;
        this.clientSecretary = clientSecretary;
    }

    @Override
    public void run() {
        scanAndRunCommands();
    }

    private void scanAndRunCommands() {
        while (scanner.hasNextLine()) {
            try {
                String requestPacketJson = scanner.nextLine();
                runCommand(requestPacketJson);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private void runCommand(String requestPacketJson) {
        RequestPacket requestPacket = new YaGson().fromJson(requestPacketJson, RequestPacket.class);
        clientSecretary.respondToRequest(requestPacket);
    }
}
