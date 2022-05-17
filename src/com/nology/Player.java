package com.nology;

public class Player {
    private String name;
    private int score;
    private String input;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int setScore(int score) {
        this.score = score;
        return score;
    }

    public int getScore() {
        return score;
    }

    public String getInput( String word) {
        input = word.toLowerCase();
        return input;
    }
}
