package models;

import com.gilecode.yagson.YaGson;
import view.packets.CommandPacket;

import java.util.Scanner;

public class CommandListener extends Thread {
    private Scanner scanner;

    public CommandListener(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        scanAndRunCommands();
    }

    public void scanAndRunCommands() {
        while (scanner.hasNextLine()) {
            try {
                String commandPacketJson = scanner.nextLine();
                runCommand(commandPacketJson);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private void runCommand(String commandPacketJson) {
        CommandPacket commandPacket = new YaGson().fromJson(commandPacketJson, CommandPacket.class);
        commandPacket.doCommand();
    }
}
