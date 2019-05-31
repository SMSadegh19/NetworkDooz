package client.view.menuItems;


import client.view.graphicElements.sceneMakers.InGameSceneMaker;

import static client.view.menuItems.MenuConstants.IN_GAME_MENU;

public class InGameMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = IN_GAME_MENU;

        //no sub menu

        sceneMaker = new InGameSceneMaker();
    }
}
