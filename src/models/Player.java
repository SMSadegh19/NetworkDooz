package models;

import java.util.ArrayList;

public class Player {
    private String name;
    private String password;
    private PlayerResults playerResults = new PlayerResults();
    private ArrayList<Game> notFinishedGames = new ArrayList<>();

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // TODO: 5/27/19
}
