package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import java.util.Random;

/**
 * Created by KenN on 2/24/16.
 */
public abstract class TicTacToeStrategy {

    public TicTacToeStrategy(){

    }

    public TicTacToeStrategy(GameBoard gameBoard) {

    }

    public abstract int getBestMove();

    protected int getRandomMove() { //rturn random number 1-9
        int move = 0;

        Random rand = new Random();
        move = rand.nextInt(9) + 1;

        return move;
    }

    public static void main(String[] args) {
        testGetRandomMove ();
    }

    public static void testGetRandomMove() {
        System. out .println();
        System. out .println( "");
        System. out .println( "Testing getRandomMove method" );
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
        int numberOfRuns = 100;
        for ( int i= 0; i<numberOfRuns; i++){
            int result = strategy.getRandomMove();
            System.out.println(result);
            if (result < 1 || result > 9 ){
                error = true;
                System. out .println( "Error! Result " + result + " is out of bounds. Must be between 1 and 9" );
            } else if (board.isSquareOpen(result,"TEST") == false ) {
                error = true;
                System. out .println( "Error! Square " + result + " is not open!" );
            }
        }
        if (error == false ) {
            System. out .println( "Correct. No bad output was found in " + numberOfRuns + " tries." );
        }
    }
}