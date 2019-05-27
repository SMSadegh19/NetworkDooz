package models;

import java.util.ArrayList;

public class Player {
    private String name;
    private PlayerResults playerResults = new PlayerResults();
    private ArrayList<Game> notFinishedGames = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // TODO: 5/27/19
}
