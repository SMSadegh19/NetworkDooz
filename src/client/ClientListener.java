package client;

import com.gilecode.yagson.YaGson;
import packets.UpdatePacket;
import packets.updates.Update;

import java.util.Scanner;

public class ClientListener extends Thread {
    private Scanner scanner;

    public ClientListener(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        scanAndRunCommands();
    }

    private void scanAndRunCommands() {
        while (scanner.hasNextLine()) {
            try {
                String updatePacketJson = scanner.nextLine();
                runCommand(updatePacketJson);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private void runCommand(String updatePacketJson) {
        UpdatePacket updatePacket = new YaGson().fromJson(updatePacketJson, UpdatePacket.class);
        Update update = updatePacket.getUpdate();
        update.updateClient();
    }
}
