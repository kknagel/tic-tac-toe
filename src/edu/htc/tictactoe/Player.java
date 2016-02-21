package edu.htc.tictactoe;

import java.util.Scanner;

/**
 * Created by KenN on 2/8/16.
 */
public class Player {
    private String name;
    private char gameMarker;
    private int winCounter = 0;
    private int squareSelected;


    public Player(String name,char marker) {
        this.name = name;
        this.gameMarker = marker;
    }

    public static void main(String[] args){
        System.out.println("Set player1 to marker X");
        Player player1 = new Player("Player1", 'X');

        System.out.println("Player1 marker should be x " + player1.getGameMarker());
        System.out.println("Player1 name should be Player1 " + player1.getName());
        System.out.println("Enter value 1 - 9");
        System.out.println(player1.getMove() + " Was entered by user");
    }

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

    public int getMove() {
        String keyboardInput;
        Boolean digits;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            keyboardInput = scanner.next();         //request input from user
            digits = keyboardInput.matches("\\d"); //must be numeric

            if (!digits) {
                System.out.println("Enter value 1 - 9");
            } else {
                squareSelected = Integer.parseInt(keyboardInput);
                if (squareSelected > 0 && squareSelected <= 9) {
                    break;
                } else System.out.println("Enter value 1 - 9");
            }
        }
        return squareSelected;
    }
}
