package client.view.graphicElements.sceneMakers;

import client.ClientMaster;
import client.view.MenuHandler;
import client.view.graphicElements.ExitButton;
import client.view.graphicElements.MyButton;
import client.view.graphicElements.MyGridPane;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import packets.requests.JoinRequest;
import packets.requests.Request;

import static client.view.menuItems.MenuConstants.SCOREBOARD_MENU;

public class ProfileSceneMaker extends SceneMaker {

    @Override
    public Scene makeScene() {
        Group group = new Group();

        Text usernameLabel = new Text("Username: ");
        usernameLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bolder;");

        TextField usernameField = new TextField();

        Button scoreboardButton = new MyButton("Scoreboard");
        scoreboardButton.setOnMouseClicked(event -> MenuHandler.goToSubMenu(SCOREBOARD_MENU));

        Button joinButton = new MyButton("Join");
        joinButton.setOnMouseClicked(event -> {
            Request request = new JoinRequest(usernameField.getText());
            ClientMaster.sendRequest(request);
        });

        Button exitButton = new ExitButton();

        GridPane gridPane = new MyGridPane();

        gridPane.add(scoreboardButton, 0, 0);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(joinButton, 1, 2);
        gridPane.add(exitButton, 0, 3);

//        todo ImageView backgroundView = Background.getInstance(1);
//        if (backgroundView != null) {
//            group.getChildren().add(backgroundView);
//        }

        group.getChildren().add(gridPane);

        return new Scene(group, 1000, 600);
    }
}
