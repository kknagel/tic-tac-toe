package edu.htc.tictactoe;

import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Scanner;

public class TicTacToe {

    public void playGame() {
        int x = 0;
        int playerMove = 0; //player square selection
        boolean spaceOpen = false, roundDone = false;
        int gameCounter = 0;
        int numberOfDraws = 0;
        char userAnswer;
        char userPCAnswer;

        GameBoard gb = new GameBoard();
        System.out.println("****************************");
        System.out.println("** Welcome to Tic-Tac-Toe **");
        System.out.println("****************************\n");

        userPCAnswer = getUserResponse("Hi, do you want to play against the computer? (Y/N)", new String[]{"Y", "N"}); //play against computer
        Player[] myPlayers = new Player[2];

        myPlayers[0] = new HumanPlayer(getPlayerName("Player1"), userAnswer = getUserResponse("Enter marker desired (X/O)?", new String[]{"X", "O"})); //set player1

        if (userAnswer == 'X') userAnswer = 'O';
            else userAnswer = 'X';

        switch (userPCAnswer){
            case 'Y':
                myPlayers[1] = new ComputerPlayer("CPU", userAnswer);
                break;
            case 'N':
                myPlayers[1] = new HumanPlayer(getPlayerName("Player2"), userAnswer);
                break;
        }

        do {
            do {
                gb.display();
                if (!roundDone) {
                    System.out.println(myPlayers[x].getName() + "(" + myPlayers[x].getGameMarker() + ") please enter square to take: ");
                    spaceOpen = false;
                    while (!spaceOpen) {
                        playerMove = myPlayers[x].getMove(); //get valid move
                        spaceOpen = gb.isSquareOpen(playerMove); // need open square
                    }
                    gb.updateSquareValue(playerMove, myPlayers[x].getGameMarker());
                    roundDone = gb.isGameWon(playerMove, myPlayers[x].getGameMarker()); //winner?

                    if (roundDone) {
                        myPlayers[x].addWin();
                        System.out.println(myPlayers[x].getName() + " wins!");
                    } else if (gb.getOpenSquares().length == 0) { //if array is empty then it is a draw
                        roundDone = true;
                        numberOfDraws += 1;
                        System.out.println("Game is a draw.");
                    }
                }
                if (x == 0) {
                    x = 1;
                } else x = 0;
            } while (!roundDone);
            //save game counter
            roundDone = false;
            gameCounter += 1; //retain number played

            userAnswer = getUserResponse("Want to play again? (Y/N)", new String[]{"Y", "N"}); //play again
            if (userAnswer == 'Y') {
                gb = new GameBoard(); //start new game
                x = 0;
            }
        } while (userAnswer == 'Y');

        // display total games / wins and declare champion
        System.out.println("\nThanks for playing!\n");

        System.out.print(myPlayers[0].getName() + " (" + myPlayers[0].getGameMarker() + ") "); //player 1 wins
        for (x = 0; x < 35 - myPlayers[0].getName().length(); x++) {
            System.out.print("-");
        }
        System.out.println(": " + myPlayers[0].getWinCounter());

        System.out.print(myPlayers[1].getName() + " (" + myPlayers[1].getGameMarker() + ") "); //player 2 wins
        for (x = 0; x < 35 - myPlayers[1].getName().length(); x++) {
            System.out.print("-");
        }
        System.out.println(": " + myPlayers[1].getWinCounter());

        System.out.print("DRAWS "); //number of ties
        for (x = 0; x < 34; x++) {
            System.out.print("-");
        }
        System.out.print(": ");
        System.out.println(numberOfDraws);

        System.out.print("TOTAL GAMES "); //total games played
        for (x = 0; x < 28; x++) {
            System.out.print("-");
        }
        System.out.println(": " + gameCounter);

        if (myPlayers[0].getWinCounter() > myPlayers[1].getWinCounter()) {    //grand champion
            System.out.println("\n********** " + myPlayers[0].getName() + " IS THE CHAMPION **********");
        } else if (myPlayers[0].getWinCounter() < myPlayers[1].getWinCounter()) {
            System.out.println("\n********** " + myPlayers[1].getName() + " IS THE CHAMPION **********");
        } else System.out.println("\n*************** TIE SCORE ***************");
    }

    private String getPlayerName(String name) {

        System.out.println("Please enter name for " + name);  //get player name
        Scanner getName = new Scanner(System.in);
        name = getName.next().toUpperCase();

        return name;
    }

    public char getUserResponse(String message, String[] values) { //get x/o or y/n response from user
        String answer;
        char result = ' ';

        System.out.println(message);
        Scanner getMarker = new Scanner(System.in);

        while (getMarker.hasNext()) {
            answer = getMarker.next();
            if (answer.equalsIgnoreCase(values[0])) {
                result = values[0].charAt(0);
                break;
            } else if (answer.equalsIgnoreCase(values[1])) {
                result = values[1].charAt(0);
                break;
            }
        }
        return result;
    }
}
