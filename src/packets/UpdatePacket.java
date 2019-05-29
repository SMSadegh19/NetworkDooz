package packets;

import packets.updates.Update;

public class UpdatePacket {
    private Update update;

    public UpdatePacket(Update update) {
        this.update = update;
    }

    public Update getUpdate() {
        return update;
    }
}
