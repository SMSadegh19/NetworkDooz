package client;

import com.gilecode.yagson.YaGson;
import packets.RequestPacket;
import packets.requests.Request;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientMaster {
    private static Socket socket;
    private static PrintStream printStream;
    private static String currentPlayerName;

    public static void setSocket(Socket socket) throws IOException {
        ClientMaster.socket = socket;
        ClientMaster.printStream = new PrintStream(socket.getOutputStream());
    }

    public static void setCurrentPlayerName(String name) {
        ClientMaster.currentPlayerName = name;
    }

    public static void sendRequest(Request request) {
        RequestPacket requestPacket = new RequestPacket(request);
        String requestPacketJson = new YaGson().toJson(requestPacket);
        printStream.println(requestPacketJson);
        printStream.flush();
    }
}
