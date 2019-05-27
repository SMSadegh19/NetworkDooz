package view.packets.requests;

import models.ClientSecretary;

public class SendMessageRequest extends Request {
    private String message;

    public SendMessageRequest(String message) {
        this.message = message;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        // TODO: 5/27/19
    }
}
