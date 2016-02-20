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


    private Boolean test2;

    public Player(String name) {
        String again;

        System.out.println("Please enter name for " + name);
        Scanner getNameAndMarker = new Scanner(System.in);
        this.name = getNameAndMarker.next().toUpperCase();

        System.out.println("Does " + this.name + " wish to play as X (Y/N)?");

        if (name == "Player1") { //only ask the first player what game marker they want
            while (getNameAndMarker.hasNext()) {
                again = getNameAndMarker.next();
                if (again.equalsIgnoreCase("Y")) {
                    this.gameMarker = 'X'; //set player to X
                    break;
                } else if (again.equalsIgnoreCase("N")) {
                    this.gameMarker = 'O'; //set player to O
                    break;
                }
            }
        }
    }

//    public static void main(String[] args){
//        System.out.println("Prompt for name and game marker");
//        Player player1 = new Player("Player1");
//        System.out.println("Prompt user for 1-9");
//        player1.getMove();
//
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
