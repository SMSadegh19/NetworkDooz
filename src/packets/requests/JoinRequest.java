package packets.requests;

import packets.updates.ErrorUpdate;
import packets.updates.PlayerLoginUpdate;
import packets.updates.Update;
import server.ClientSecretary;
import models.Player;
import server.ServerContents;

public class JoinRequest extends Request {
    private String playerName;

    public JoinRequest(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        if (ServerContents.findPlayer(playerName) == null) {
            requesterClientSecretary.setPlayer(new Player(playerName));

            Update update = new PlayerLoginUpdate(playerName);
            requesterClientSecretary.updateClient(update);
            //Finished
            // todo JUST test it
        } else {
            Update update = new ErrorUpdate("Player with this name is already exist!");
            requesterClientSecretary.updateClient(update);
            //Finished
            // todo JUST test it
        }
    }
}
