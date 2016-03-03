package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by KenN on 2/24/16.
 */
public abstract class TicTacToeStrategy {

    public TicTacToeStrategy() {

    }

    public TicTacToeStrategy(GameBoard gameBoard) {

    }

    public abstract int getBestMove();


    protected int getRandomMove(int size, int addInt) { //rturn random number 1-9
        int move = 0;

        Random rand = new Random();
        move = rand.nextInt(size) + addInt;

        return move;
    }

    protected int getBestOpenMove(GameBoard board) {
        int x;
        int result;

        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();

        //find all odds and evens
        for (x = 0; x < GameBoard.openSquares.size(); x++) { //tried for each loop problem with index didn't start at 0
            //System.out.println(openList.get(x));
            if (GameBoard.openSquares.get(x) % 2 != 0) {
                odds.add(GameBoard.openSquares.get(x));
            } else evens.add(GameBoard.openSquares.get(x));
        }
        int oddSize = odds.size();
        int evenSize = evens.size();

        if (oddSize > 0){
            if (GameBoard.isSquareOpen(5, "CPU")) {
                result = 5;
            } else {
                result = getRandomMove(oddSize, 0);
                return  odds.get(result);
            }
        } else {
            result = getRandomMove(evenSize, 0);
            return evens.get(result);
        }

        return result;

    }

    public static void main(String[] args) {

        testGetRandomMove();
        testGetBestOpenMove();
    }

    public static void testGetRandomMove() {
        System.out.println();
        System.out.println("");
        System.out.println("Testing getRandomMove method");
        //GameBoard board = new GameBoard( new char []{ '1' , 'X' , '3' , '4' , 'O' , '6' , 'X' , '8' , 'O' });
        GameBoard board = new GameBoard();
        board.updateSquareValue(2, 'X');
        board.updateSquareValue(5, 'O');
        board.updateSquareValue(7, 'X');


// Creates anonymous inner class with dummy getBestMove behavior.
        TicTacToeStrategy strategy = new TicTacToeStrategy(board) {
            public int getBestMove() {
                return 0;
            }
        };
// Since result is random, testing multiple times to validate good output
        boolean error = false;
        int numberOfRuns = 10;
        for (int i = 0; i < numberOfRuns; i++) {
            int result = strategy.getRandomMove(9, 1);
            System.out.println(result);
            if (result < 1 || result > 9) {
                error = true;
                System.out.println("Error! Result " + result + " is out of bounds. Must be between 1 and 9");
            } else if (board.isSquareOpen(result, "TEST") == false) {
                error = true;
                System.out.println("Error! Square " + result + " is not open!");
            }
        }
        if (error == false) {
            System.out.println("Correct. No bad output was found in " + numberOfRuns + " tries.");
        }
    }

    //****************************************************


    public static void testGetBestOpenMove() {
        int x;
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");

        System.out.println("Testing getBestOpenMove method");
        GameBoard board = new GameBoard();
        board.updateSquareValue(2, 'X');
        board.updateSquareValue(3, 'O');
        board.updateSquareValue(7, 'X');
        board.updateSquareValue(9, 'O');

        // Creates anonymous inner class with dummy getBestMove behavior.
        TicTacToeStrategy strategy2 = new TicTacToeStrategy(board) {
            public int getBestMove() {
                return 0;
            }
        };

        board.display();
        System.out.println("Best move is now 5");
        int result = strategy2.getBestOpenMove( board); //should return 5
        board.updateSquareValue(result, 'X');
        System.out.println("5 is now taken as X");
        board.display();

        System.out.println("Best move is now 1 as 3 corners are taken");
        result = strategy2.getBestOpenMove( board); //should return 1
        board.updateSquareValue(result, 'O');
        System.out.println("1 is now taken as O");
        board.display();

        System.out.println("Best move is now is any side as all corners are taken");
        for (x=0;x<25; x++) {
            result = strategy2.getBestOpenMove(board); //should return any side 4,6 or 8
            System.out.println(result);
        }
        board.display();

    }


}
