package client.view.menuItems;

import client.view.graphicElements.sceneMakers.SceneMaker;
import javafx.scene.Scene;

import java.util.ArrayList;

public abstract class MenuItem {
    protected String name;
    protected MenuItem parentMenu = null;
    protected ArrayList<MenuItem> subMenus = new ArrayList<>();
    protected SceneMaker sceneMaker = null;

    {
        initMenuItem();
//        commands.add(new HelpCommand());
//        commands.add(new ExitCommand());
    }

    public String getName() {
        return name;
    }

    public MenuItem getParentMenu() {
        return parentMenu;
    }

    public ArrayList<MenuItem> getSubMenus() {
        return subMenus;
    }

    public void setParentMenu(MenuItem parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Scene getNewScene() {
        return sceneMaker.makeScene();
    }

    protected abstract void initMenuItem();
}