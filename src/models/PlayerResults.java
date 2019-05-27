package models;

public class PlayerResults {
    private int numberOfWins = 0;
    private int numberOfLosses = 0;
    private int numberOfDraws = 0;

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void incrementNumberOfResults(char numberOf) {
        switch (numberOf) {
            case 'w':
                numberOfWins++;
                break;
            case 'l':
                numberOfLosses++;
                break;
            case 'd':
                numberOfDraws++;
                break;
        }
    }
}
