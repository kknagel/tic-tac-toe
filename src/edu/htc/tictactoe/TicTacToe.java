package edu.htc.tictactoe;

import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Scanner;

public class TicTacToe {
    public static int levelOfPlay=0;
    public static final boolean DEBUG_MESSAGES = false; //show messages to validate play
    public static Player[] myPlayers = new Player[2];
    public static int numberOfDraws = 0;
    public static int gameCounter = 0;

    public void playGame() {

        int x = 0;  //players turn -- 0 is player1
        int playerMove = 0; //player square selection
        boolean spaceOpen = false, roundDone = false;
        char userAnswer;

        GameBoard gb = new GameBoard();

        if (DEBUG_MESSAGES) {
            System.out.println("Simple-CPU random; Easy-CPU best open; Medium-Block player1; Hard-Go for win");
        }
        levelOfPlay = getUserNumericResponse("1. Play with friend\n2. Play Against CPU Simple\n3. Play against CPU Easy\n4. Play against CPU Medium\n5. Play against CPU Hard\n", 1, 5); //play  level 1-4

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
                if (x == 0) {  //if player1 is current switch to player2
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
    }

    /******************************************
     *
     *      helper methods to get user input
     *
     ******************************************/
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

        answer = getMarker.next();
        while (!answer.equalsIgnoreCase(values[0]) && !answer.equalsIgnoreCase(values[1])) {    //more shapes
            System.out.println("Sorry, you must enter either " + values[0] + " or " + values[1]);
            answer = getMarker.next();
        }
        result = answer.toUpperCase().charAt(0);

        return result;
    }

    public static int getUserNumericResponse(String message, int low, int high){
        int keyboardInput = 0;

        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter selection " + low + " - " + high);

            try {
                keyboardInput = Integer.parseInt(scanner.next());            //get size and catch string data
            } catch (NumberFormatException e) {
                System.out.println("Please enter a integer value " + low + " - " + high);
            } catch (Exception other) {
                System.out.println("Something else happened");
            }

        } while (keyboardInput < low || keyboardInput > high);

        return keyboardInput;
    }
}
