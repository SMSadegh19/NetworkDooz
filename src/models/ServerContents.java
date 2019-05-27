package models;

import java.util.ArrayList;

public class ServerContents {
    private static ArrayList<ClientSecretary> clientSecretaries = new ArrayList<>();

    public static void addClient(ClientSecretary clientSecretary) {
        clientSecretaries.add(clientSecretary);
    }

    public static Player findPlayer(String name) {
        for (ClientSecretary clientSecretary : clientSecretaries) {
            Player player = clientSecretary.getPlayer();
            if (player != null && player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    // TODO: 5/27/19
}
