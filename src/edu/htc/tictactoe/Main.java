package edu.htc.tictactoe;

public class Main {

    public static void main(String[] args) {
        int x;

        System.out.println("****************************");
        System.out.println("** Welcome to Tic-Tac-Toe **");
        System.out.println("****************************\n");

        TicTacToe game = new TicTacToe();
        game.playGame();

        // display total games / wins and declare champion
        System.out.println("\nThanks for playing!\n");

        System.out.print(TicTacToe.myPlayers[0].getName() + " (" + TicTacToe.myPlayers[0].getGameMarker() + ") "); //player 1 wins
        for (x = 0; x < 35 - TicTacToe.myPlayers[0].getName().length(); x++) {
            System.out.print("-");
        }
        System.out.println(": " + TicTacToe.myPlayers[0].getWinCounter());

        System.out.print(TicTacToe.myPlayers[1].getName() + " (" + TicTacToe.myPlayers[1].getGameMarker() + ") "); //player 2 wins
        for (x = 0; x < 35 - TicTacToe.myPlayers[1].getName().length(); x++) {
            System.out.print("-");
        }
        System.out.println(": " + TicTacToe.myPlayers[1].getWinCounter());

        System.out.print("DRAWS "); //number of ties
        for (x = 0; x < 34; x++) {
            System.out.print("-");
        }
        System.out.print(": ");
        System.out.println(TicTacToe.numberOfDraws);

        System.out.print("TOTAL GAMES "); //total games played
        for (x = 0; x < 28; x++) {
            System.out.print("-");
        }
        System.out.println(": " + TicTacToe.gameCounter);

        if (TicTacToe.myPlayers[0].getWinCounter() > TicTacToe.myPlayers[1].getWinCounter()) {    //grand champion
            System.out.println("\n********** " + TicTacToe.myPlayers[0].getName() + " IS THE CHAMPION **********");
        } else if (TicTacToe.myPlayers[0].getWinCounter() < TicTacToe.myPlayers[1].getWinCounter()) {
            System.out.println("\n********** " + TicTacToe.myPlayers[1].getName() + " IS THE CHAMPION **********");
        } else System.out.println("\n*************** TIE SCORE ***************");
    }
}