package client.view.menuItems;

import client.view.graphicElements.sceneMakers.MainMenuSceneMaker;

import static client.view.menuItems.MenuConstants.MAIN_MENU;

public class MainMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = MAIN_MENU;

        subMenus.add(new InGameMenu());

        sceneMaker = new MainMenuSceneMaker();
    }
}
