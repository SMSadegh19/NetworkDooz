package models;

import java.util.ArrayList;

public class ServerContents {
    private static ArrayList<Client> clients = new ArrayList<>();

    public static void addClient(Client client) {
        clients.add(client);
    }


    // TODO: 5/27/19
}
