package view.packets.requests;

import models.ClientSecretary;

public abstract class Request {
    public abstract void respondToRequest(ClientSecretary requesterClientSecretary);
}
