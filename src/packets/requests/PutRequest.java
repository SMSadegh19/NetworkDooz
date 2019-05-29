package packets.requests;

import server.ClientSecretary;

public class PutRequest extends Request {
    private int putRow;
    private int putColumn;

    public PutRequest(int putRow, int putColumn) {
        this.putRow = putRow;
        this.putColumn = putColumn;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        // TODO: 5/27/19
    }
}
