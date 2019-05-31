package packets.updates;

import client.view.Notify;

public class ErrorUpdate extends Update {
    private String error;

    public ErrorUpdate(String error) {
        this.error = error;
    }

    @Override
    public void updateClient() {
        Notify.logError(this.error);
    }
}
