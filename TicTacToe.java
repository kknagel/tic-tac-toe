package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public void playGame() {
        int x;
        int player1Move = 0, player2Move = 0; //player square selection
        String again = "N"; //default value for another game? message
        boolean spaceOpen = false, roundDone = false;
        int gameCounter = 0;
        int numberOfDraws = 0;

        GameBoard gb = new GameBoard();
        System.out.println("****************************");
        System.out.println("** Welcome to Tic-Tac-Toe **");
        System.out.println("****************************\n");

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        if (player1.getGameMarker() == 'X') { //set player 2 mark opposite player1
            player2.setGameMarker('O');
        } else player2.setGameMarker('X');


        do {
            do {
                if (!roundDone || !spaceOpen) {
                    gb.display();
                    System.out.println(player1.getName() + "(" + player1.getGameMarker() + ") please enter square to take: ");
                    spaceOpen = false;
                    while (!spaceOpen) {
                        player1Move = player1.getMove(); //get valid move
                        spaceOpen = gb.isSquareOpen(player1Move); // need open square
                    }
                    gb.updateSquareValue(player1Move, player1.getGameMarker());
                    roundDone = gb.isGameWon(player1Move, player1.getGameMarker()); //winner?

                    if (roundDone) {
                        player1.addWin();
                        System.out.println(player1.getName() + " wins!");
                    } else if (gb.getOpenSquares().length == 0) { //if array is empty then it is a draw
                        roundDone = true;
                        numberOfDraws += 1;
                        System.out.println("Game is a draw.");
                    }
                }
                if (!roundDone || !spaceOpen) {
                    gb.display();
                    System.out.println(player2.getName() + "(" + player2.getGameMarker() + ") please enter square to take: ");
                    spaceOpen = false;
                    while (!spaceOpen) {
                        player2Move = player2.getMove(); //get valid move
                        spaceOpen = gb.isSquareOpen(player2Move); //need open square
                    }
                    gb.updateSquareValue(player2Move, player2.getGameMarker());
                    roundDone = gb.isGameWon(player2Move, player2.getGameMarker()); //winner?

                    if (roundDone) {
                        player2.addWin();
                        System.out.println(player2.getName() + " Wins!");
                    }
                    if (gb.getOpenSquares().length == 0) { //if array is empty then it is a draw
                        roundDone = true;
                        numberOfDraws += 1;
                        System.out.println("Game is a draw.");
                    }
                }
            } while (!roundDone);
            //save game counter
            roundDone = false;
            gameCounter += 1; //retain number played

            System.out.println("Want to play again? (Y/N) ");
            Scanner playAgain = new Scanner(System.in);
            while (playAgain.hasNext()) {
                System.out.println("Enter Y or N");
                again = playAgain.next();
                if (again.equalsIgnoreCase("Y")) {
                    gb = new GameBoard(); //start new game
                    break;
                } else if (again.equalsIgnoreCase("N")) break;
            }
        } while (again.equalsIgnoreCase("Y"));


        // display total games / wins and declare champion
        System.out.println("\nThanks for playing!\n");

        System.out.print(player1.getName() + " (" + player1.getGameMarker() + ") "); //player 1 wins
        for (x = 0; x < 35 - player1.getName().length(); x++) {
            System.out.print("-");
        }
        System.out.println(": " + player1.getWinCounter());

        System.out.print(player2.getName() + " (" + player2.getGameMarker() + ") "); //player 2 wins
        for (x = 0; x < 35 - player2.getName().length(); x++) {
            System.out.print("-");
        }
        System.out.println(": " + player2.getWinCounter());

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

        if (player1.getWinCounter() > player2.getWinCounter()) {    //grand champion
            System.out.println("\n********** " + player1.getName() + " IS THE CHAMPION **********");
        } else if (player1.getWinCounter() < player2.getWinCounter()) {
            System.out.println("\n********** " + player2.getName() + " IS THE CHAMPION **********");
        } else System.out.println("\n*************** TIE SCORE ***************");
    }
}
