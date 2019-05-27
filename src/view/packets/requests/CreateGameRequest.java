package view.packets.requests;

import models.ClientSecretary;

public class CreateGameRequest extends Request {
    private String opponentName;
    private int numberOfRows;
    private int numberOfColumns;

    public CreateGameRequest(String opponentName, int numberOfRows, int numberOfColumns) {
        this.opponentName = opponentName;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        // TODO: 5/27/19
    }
}
