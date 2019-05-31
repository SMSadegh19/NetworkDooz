package client;

import client.view.MenuHandler;
import client.view.graphicElements.sceneMakers.ProfileSceneMaker;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DoozClient extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuHandler.setStage(primaryStage);
        primaryStage.setScene(new ProfileSceneMaker().makeScene());// TODO: 5/30/19 may change
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        ClientMaster.setSocket(socket);

        ClientListener listenerThread = new ClientListener(new Scanner(socket.getInputStream()));
        listenerThread.start();

        MenuHandler.startFirstMenu();
        launch(args);
    }
}
