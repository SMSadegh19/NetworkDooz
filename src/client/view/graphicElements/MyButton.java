package client.view.graphicElements;

import javafx.scene.control.Button;

public class MyButton extends Button {
    public MyButton(String text) {
        super(text);
        setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        setOnMouseExited(event -> setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"));
        setOnMouseEntered(event -> setStyle("-fx-background-color: #6a5b8b; -fx-text-fill: #ff8d90;"));
    }
}
