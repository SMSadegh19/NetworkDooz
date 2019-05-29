package packets.requests;

import server.ClientSecretary;
import models.Player;
import server.ServerContents;

public class CreatePlayerRequest extends Request {
    private String playerName;

    public CreatePlayerRequest(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        if (ServerContents.findPlayer(playerName) != null) {
            requesterClientSecretary.setPlayer(new Player(playerName));
            // TODO: 5/27/19 : send data: username verified and set
        } else {
            // TODO: 5/27/19 :  send data: error to client
        }
    }
}
