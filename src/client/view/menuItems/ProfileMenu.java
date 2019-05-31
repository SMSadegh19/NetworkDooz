package client.view.menuItems;


import client.view.graphicElements.sceneMakers.ProfileSceneMaker;

import static client.view.menuItems.MenuConstants.PROFILE_MENU;

public class ProfileMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = PROFILE_MENU;

        subMenus.add(new MainMenu());
        subMenus.add(new ScoreboardMenu());

        sceneMaker = new ProfileSceneMaker();
    }
}
