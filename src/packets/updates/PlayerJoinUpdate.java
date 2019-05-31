package packets.updates;

import client.ClientMaster;
import client.view.MenuHandler;
import client.view.Notify;
import javafx.application.Platform;

import static client.view.menuItems.MenuConstants.MAIN_MENU;

public class PlayerJoinUpdate extends Update {
    private String playerName;

    public PlayerJoinUpdate(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void updateClient() {
        Platform.runLater(() -> {
            ClientMaster.setCurrentPlayerName(playerName);
            MenuHandler.goToSubMenu(MAIN_MENU);
            Notify.logMessage("Welcome " + playerName + "!! :))");
            // TODO: JUST TEST it
        });
    }
}
