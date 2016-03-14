package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by KenN on 2/8/16.
 */
public abstract class Player {
    public String name;
    public char gameMarker;
    private int winCounter = 0;


    public Player(){
    }

    public Player(String name,char marker) {
        this.name = name;
        this.gameMarker = marker;
    }

    public abstract int getMove(); //get move based on user type

    public void setGameMarker(char gameMarker) { //set game marker for player
        this.gameMarker = gameMarker;
    }

    public String getName() { //get players name
        return name;
    }

    public char getGameMarker() {
        return gameMarker;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void addWin() {
        this.winCounter += 1; //won a round
    }
}