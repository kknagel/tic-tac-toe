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

    public abstract int getMove();


//    public static void main(String[] args){
//        System.out.println("Set player1 to marker X");
//        Player player1 = new Player("Player1", 'X');
//
//        System.out.println("Player1 marker should be x " + player1.getGameMarker());
//        System.out.println("Player1 name should be Player1 " + player1.getName());
//        System.out.println("Enter value 1 - 9");
//        System.out.println(player1.getMove() + " Was entered by user");
//    }

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
        this.winCounter += 1; //won a game
    }


}
