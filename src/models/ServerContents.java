package models;

import java.util.ArrayList;

public class ServerContents {
    private static ArrayList<ClientSecretary> clientSecretaries = new ArrayList<>();

    public static void addClient(ClientSecretary clientSecretary) {
        clientSecretaries.add(clientSecretary);
    }


    // TODO: 5/27/19
}
