package packets.requests;

import server.ClientSecretary;

public abstract class Request {
    public abstract void respondToRequest(ClientSecretary requesterClientSecretary);
}
