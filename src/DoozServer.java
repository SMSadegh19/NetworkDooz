import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class DoozServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        ServerSocket serverSocket = new ServerSocket(8888);
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
    }
}
