package client.view.graphicElements;


import client.view.MenuHandler;

public class ExitButton extends MyButton {
    public ExitButton() {
        super("Exit");
        setOnMouseClicked(event -> MenuHandler.goToParentMenu());
    }
}
