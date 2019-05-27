package models;

import com.gilecode.yagson.YaGson;
import view.packets.RequestPacket;

import java.util.Scanner;

public class CommandListener extends Thread {
    private Scanner scanner;
    private ClientSecretary clientSecretary;

    public CommandListener(Scanner scanner, ClientSecretary clientSecretary) {
        this.scanner = scanner;
        this.clientSecretary = clientSecretary;
    }

    @Override
    public void run() {
        scanAndRunCommands();
    }

    public void scanAndRunCommands() {
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
