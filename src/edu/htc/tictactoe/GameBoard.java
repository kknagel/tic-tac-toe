package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by KenN on 2/9/16.
 */

public class GameBoard {
    public static ArrayList<Integer> openSquares;
    public static char[] board;
    public static int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    public GameBoard() {   //initialize gameboard array
        int x;
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        openSquares = new ArrayList<Integer>(9);
        for (x = 1; x < 10; x++) {
            openSquares.add(x);
        }
    }



    public void display() {
        int x;

        System.out.println(" *************");
        for (x = 0; x < 3; x++) {
            System.out.print(" | " + board[x]);
        }
        System.out.println(" |");
        System.out.println(" |---+---+---|");
        for (x = 3; x < 6; x++) {
            System.out.print(" | " + board[x]);
        }
        ;
        System.out.println(" |");
        System.out.println(" |---+---+---|");
        for (x = 6; x < 9; x++) {
            System.out.print(" | " + board[x]);
        }
        System.out.println(" |");
        System.out.println(" *************");
    }
    /*
    Using last input from the user to scan the board array for that square and determine if that array contains the same
    player mark for all members within that sub array and if so return true
     */
    public boolean isGameWon(int lastMove, char playerMark) {

        boolean result = false;
        int x, y;

        for (x = 0; x < winCombinations.length; x++) {
            for (y = 0; y < 3; y++) {
                if (winCombinations[x][y] == lastMove) { //find last move in array
                    if (board[winCombinations[x][0] - 1] == playerMark &&
                            board[winCombinations[x][1] - 1] == playerMark &&
                            board[winCombinations[x][2] - 1] == playerMark) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int[] getOpenSquares() {

        int[] intArray = openSquares.parallelStream().mapToInt(Integer::intValue).toArray();

        return intArray;
    }

    public static boolean isSquareOpen(int open, String playerName) {
        boolean squareIsOpen;

        squareIsOpen = openSquares.contains(new Integer(open));
        if (squareIsOpen) {
            return true;
        } else {
            if (playerName != "CPU") { //avoid reporting error if CPU
                System.out.println("Sorry the square you selected is not available, try again.");
            }
            return false;
        }
    }

    public void updateSquareValue(int number, char playerMark) {
        this.board[number - 1] = playerMark;
        openSquares.remove(new Integer(number));
    }

    public static char getSquareValue(int square) {
        return board[square];
        //not sure why we need this
    }

    public static void main(String[] args){
        GameBoard gb = new GameBoard();
        gb.testGameboard();

    }

    private void testGameboard(){
        int x;
        int[] zeroRecords = {1,2,3};

        updateSquareValue(8,'X');
        System.out.println(board);
        updateSquareValue(3,'X');
        System.out.println(board);
        updateSquareValue(4,'O');
        display();

        //test is square open
        System.out.println("Is square 3 open? " + isSquareOpen(3,"TEST"));
        System.out.println("Is square 8 open? " + isSquareOpen(8,"TEST"));
        System.out.println("Is square 4 open? " + isSquareOpen(4,"TEST"));
        System.out.println("Is square 1 open? " + isSquareOpen(1,"TEST"));

        //test is game won
        System.out.println("\nis game won? " + isGameWon(3, 'X'));

        //display square value
        System.out.println("\nValue in square 4 should be O " + getSquareValue(4-1));
        System.out.println("Value in square 3 should be X " + getSquareValue(3-1));

        //validate is game won
        System.out.println(board);
        System.out.println("Reset board value");
        board[4-1] = '4';
        System.out.println(board);
        updateSquareValue(1,'X');
        System.out.println("\nis game won? " + isGameWon(2, 'X'));

        System.out.println(board);
        display();
        updateSquareValue(2,'X');
        display();
        System.out.println("\nShould have a winner " + isGameWon(3, 'X'));

        //test full board
        board[2-1] = '2';
        updateSquareValue(4,'O');
        updateSquareValue(5,'X');
        updateSquareValue(6,'O');
        updateSquareValue(7,'O');
        updateSquareValue(9,'O');
        updateSquareValue(2,'O');
        display();

        //get square value
        System.out.println("square 9 should have marker O " + getSquareValue(9-1));
        System.out.println("square 5 should have marker X " + getSquareValue(5-1));


        System.out.println("Game is draw so return false " + isGameWon(2, 'O'));
        System.out.println("number of open squares " + getOpenSquares().length);
    }
}

