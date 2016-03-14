package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.TicTacToe;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collector;

/**
 * Created by KenN on 2/24/16.
 */
public abstract class TicTacToeStrategy {

    public TicTacToeStrategy() {
    }

    public TicTacToeStrategy(GameBoard gameBoard) {
    }

    public abstract int getBestMove();

    public abstract int getBestMove(char playerMark);


    protected int getRandomMove(int size, int addInt) { //rturn random number 1-9
        int move = 0;

        Random rand = new Random();
        move = rand.nextInt(size) + addInt;
        if (TicTacToe.DEBUG_MESSAGES) {
            System.out.println("Play random move strategy: " + move);
        }
        return move;
    }

    protected int getBestOpenMove() {
        //protected int getBestOpenMove(GameBoard board) {

        int x;
        int result;

        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();

        //find all odds and evens
        for (x = 0; x < GameBoard.openSquares.size(); x++) { //tried for each loop problem with index didn't start at 0

            if (GameBoard.openSquares.get(x) % 2 != 0) {
                odds.add(GameBoard.openSquares.get(x)); //build array of odd numbers that are open
            } else evens.add(GameBoard.openSquares.get(x)); //build array of even numbers that are open
        }
        int oddSize = odds.size();
        int evenSize = evens.size();
        if (TicTacToe.DEBUG_MESSAGES) {
            System.out.println("\nPlay best open move strategy");
        }
        if (oddSize > 0) {
            if (GameBoard.isSquareOpen(5, "CPU")) {
                if (TicTacToe.DEBUG_MESSAGES) {
                    System.out.println("Found 5 open");
                }
                result = 5;
            } else {
                result = getRandomMove(oddSize, 0);
                if (TicTacToe.DEBUG_MESSAGES) {
                    System.out.println("Found odd open corner at: " + result);
                }
                return odds.get(result);
            }
        } else {
            result = getRandomMove(evenSize, 0);
            if (TicTacToe.DEBUG_MESSAGES) {
                System.out.println("Found even open side at: " + result);
            }
            return evens.get(result);
        }

        return result;

    }

    public int findWinFor(char playerMark) {
        int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
        int result = -1;
        //int result = 0;
        int x, y;
        int count, index = -1;
        if (TicTacToe.DEBUG_MESSAGES) {
            System.out.println("\nFind a blocking/winning move strategy");
        }
        for (x = 0; x < winCombinations.length; x++) {  //cycle array of arrays
            count = 0;
            index = -1;
            for (y = 0; y < 3; y++) {       //cycle through sub arrays
                if (TicTacToe.DEBUG_MESSAGES) {
                    System.out.print(winCombinations[x][y]);
                    System.out.print(GameBoard.board[winCombinations[x][y] - 1]);
                }
                if (GameBoard.board[winCombinations[x][y] - 1] == playerMark) {
                    count += 1;  //found mark
                } else index = y; //space open
            }
            if (TicTacToe.DEBUG_MESSAGES) {
                System.out.print(" ");
            }
            if (count == 2) { //possible win/block
                result = Character.getNumericValue(GameBoard.board[winCombinations[x][index] - 1]); //is the index space number or character
                if (result > 9) {
                    result = -1; // character is larger than 9 and therefore a character not a digit
                    if (TicTacToe.DEBUG_MESSAGES) {
                        System.out.println("Skipping for opponent at: " + result);
                    }
                    continue;
                } else {
                    if (TicTacToe.DEBUG_MESSAGES) {
                        System.out.println("Found block at: " + result);
                    }
                    break;
                }

            }
        }
        return result;
    }

//    public static void main(String[] args) {
//
//        //testGetRandomMove();
//        //testGetBestOpenMove();
//        testBlockWinStrategy();
//    }
//
//    public static void testGetRandomMove() {
//        System.out.println();
//        System.out.println("");
//        System.out.println("Testing getRandomMove method");
//        //GameBoard board = new GameBoard( new char []{ '1' , 'X' , '3' , '4' , 'O' , '6' , 'X' , '8' , 'O' });
//        GameBoard board = new GameBoard();
//        board.updateSquareValue(2, 'X');
//        board.updateSquareValue(5, 'O');
//        board.updateSquareValue(7, 'X');
//
//
//// Creates anonymous inner class with dummy getBestMove behavior.
//        TicTacToeStrategy strategy = new TicTacToeStrategy(board) {
//            public int getBestMove() {
//                return 0;
//            }
//        };
//// Since result is random, testing multiple times to validate good output
//        boolean error = false;
//        int numberOfRuns = 10;
//        for (int i = 0; i < numberOfRuns; i++) {
//            int result = strategy.getRandomMove(9, 1);
//            System.out.println(result);
//            if (result < 1 || result > 9) {
//                error = true;
//                System.out.println("Error! Result " + result + " is out of bounds. Must be between 1 and 9");
//            } else if (board.isSquareOpen(result, "TEST") == false) {
//                error = true;
//                System.out.println("Error! Square " + result + " is not open!");
//            }
//        }
//        if (error == false) {
//            System.out.println("Correct. No bad output was found in " + numberOfRuns + " tries.");
//        }
//    }

    //****************************************************


//    public static void testGetBestOpenMove() {
//        int x;
//        System.out.println("**************************************");
//        System.out.println("**************************************");
//        System.out.println("**************************************");
//
//        System.out.println("Testing getBestOpenMove method");
//        GameBoard board = new GameBoard();
//        board.updateSquareValue(2, 'X');
//        board.updateSquareValue(3, 'O');
//        board.updateSquareValue(7, 'X');
//        board.updateSquareValue(9, 'O');
//
//        // Creates anonymous inner class with dummy getBestMove behavior.
//        TicTacToeStrategy strategy2 = new TicTacToeStrategy(board) {
//            public int getBestMove('X') {
//                return 0;
//            }
//        };
//
//        board.display();
//        System.out.println("Best move is now 5");
//        int result = strategy2.getBestOpenMove(board); //should return 5
//        board.updateSquareValue(result, 'X');
//        System.out.println("5 is now taken as X");
//        board.display();
//
//        System.out.println("Best move is now 1 as 3 corners are taken");
//        result = strategy2.getBestOpenMove(board); //should return 1
//        board.updateSquareValue(result, 'O');
//        System.out.println("1 is now taken as O");
//        board.display();
//
//        System.out.println("Best move is now is any side as all corners are taken");
//        for (x = 0; x < 25; x++) {
//            result = strategy2.getBestOpenMove(board); //should return any side 4,6 or 8
//            System.out.println(result);
//        }
//        board.display();
//    }

//        public static void testBlockWinStrategy(){
//
//            System.out.println("**************************************");
//            System.out.println("**************************************");
//            System.out.println("**************************************");
//
//            System.out.println("Testing blockWinStrategy method");
//            GameBoard board = new GameBoard();
//            board.updateSquareValue(1, 'X');
//            board.updateSquareValue(3, 'O');
//            board.updateSquareValue(7, 'X');
//            board.updateSquareValue(6, 'O');
//
//            // Creates anonymous inner class with dummy getBestMove behavior.
//            TicTacToeStrategy strategy3 = new TicTacToeStrategy(board) {
//                public int getBestMove() {
//                    return 0;
//                }
//            };
//            board.display();
//
//            System.out.println("should return 4");
//            int result = strategy3.findWinFor('X' ); //should return 4
//            System.out.println("square selected " + result);
//
//            System.out.println("should return 9");
//            result = strategy3.findWinFor('O' ); //should return 4
//            System.out.println("square selected " + result);
//
//
//            board.updateSquareValue(4, 'O');
//            board.display();
//
//            System.out.println("\nshould return 5");
//            result = strategy3.findWinFor('O' ); //should return 5
//            System.out.println("square selected " + result);
//
//
//
//
//        }


}
