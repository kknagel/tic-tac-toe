package edu.htc.tictactoe;

import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Scanner;

public class TicTacToe {
    public static int levelOfPlay=0;
    public static final boolean DEBUG_MESSAGES = false; //show messages to validate play

    public void playGame() {

        int x = 0;
        int playerMove = 0; //player square selection
        boolean spaceOpen = false, roundDone = false;
        int gameCounter = 0;
        int numberOfDraws = 0;
        char userAnswer;

        GameBoard gb = new GameBoard();
        System.out.println("****************************");
        System.out.println("** Welcome to Tic-Tac-Toe **");
        System.out.println("****************************\n");

        levelOfPlay = getUserNumericResponse("1. Play with friend\n2. Play Against CPU Simple\n3. Play against CPU Easy\n4. Play against CPU Medium\n5. Play against CPU Hard\n\nEnter selection 1-5", 1, 5); //play  level 1-4

        Player[] myPlayers = new Player[2];
        myPlayers[0] = new HumanPlayer(getPlayerName("Player1"), userAnswer = getUserResponse("Enter marker desired (X/O)?", new String[]{"X", "O"})); //set player1

        if (userAnswer == 'X') userAnswer = 'O'; //play as x or o
            else userAnswer = 'X';

        if (levelOfPlay > 1){
            myPlayers[1] = new ComputerPlayer("CPU", userAnswer); //play against pc
        } else myPlayers[1] = new HumanPlayer(getPlayerName("Player2"), userAnswer);

        if (DEBUG_MESSAGES){
            System.out.println("Human Player1: " + myPlayers[0].getGameMarker());
            System.out.println("CPU/Human Player2: " + myPlayers[1].getGameMarker());
        }

        do {
            do {
                gb.display();
                if (!roundDone) {
                    if (myPlayers[x].getName() != "CPU") {
                        System.out.println(myPlayers[x].getName() + "(" + myPlayers[x].getGameMarker() + ") please enter square to take: ");
                    }
                    spaceOpen = false;
                    while (!spaceOpen) {
                        playerMove = myPlayers[x].getMove(); //get valid move
                        spaceOpen = gb.isSquareOpen(playerMove, myPlayers[x].getName()); // need open square
                    }
                    gb.updateSquareValue(playerMove, myPlayers[x].getGameMarker());
                    //gb.display();
                    roundDone = gb.isGameWon(playerMove, myPlayers[x].getGameMarker()); //winner?

                    if (roundDone) {
                        myPlayers[x].addWin();
                        System.out.println(myPlayers[x].getName() + " wins with play at square number: " + playerMove);
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
    public int getUserNumericResponse(String message, int low, int high){
        String keyboardInput;
        boolean digits;
        int numericAnswer=0;

        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            keyboardInput = scanner.next();         //request input from user
            digits = keyboardInput.matches("\\d"); //must be numeric

            if (!digits) {
                System.out.println("Enter value " + low + " - " + high);
            } else {
                numericAnswer = Integer.parseInt(keyboardInput);
                if (numericAnswer >= low && numericAnswer <= high) {
                    break;
                } else System.out.println("Enter value " + low + " - " + high);
            }
        }


        return numericAnswer;
    }
}
