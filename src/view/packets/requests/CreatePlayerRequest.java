package view.packets.requests;

import models.ClientSecretary;

public class CreatePlayerRequest extends Request {
    private String playerName;

    public CreatePlayerRequest(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        // TODO: 5/27/19
    }
}
