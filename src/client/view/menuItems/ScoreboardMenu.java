package client.view.menuItems;

import client.view.graphicElements.sceneMakers.ScoreboardSceneMaker;

import static client.view.menuItems.MenuConstants.SCOREBOARD_MENU;

public class ScoreboardMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = SCOREBOARD_MENU;

        //no sub menu

        sceneMaker = new ScoreboardSceneMaker();
    }
}
