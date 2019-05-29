package packets.requests;

import server.ClientSecretary;

public class GetDataRequest extends Request {
    private DataType dataType;

    public GetDataRequest(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public void respondToRequest(ClientSecretary requesterClientSecretary) {
        switch (dataType) {
            case CHAT:

                break;
            case SCOREBOARD:

                break;
            case UNFINISHED_GAMES:

                break;
        }
    }
}
