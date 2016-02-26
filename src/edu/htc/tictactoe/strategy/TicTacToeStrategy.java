package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;

import java.util.Random;

/**
 * Created by KenN on 2/24/16.
 */
public abstract class TicTacToeStrategy {
    public GameBoard board;


    public TicTacToeStrategy(GameBoard board) {

    }

    public abstract int getBestMove();

    protected int getRandomMove() {
        int move = 1;

        Random rand = new Random();

        //int[] gb = GameBoard.main();


        return move;
    }

    public static void main(String[] args) {
        testGetRandomMove();
    }

    public static void testGetRandomMove() {
        //GameBoard board = new GameBoard(new char[]{'1', 'X', '3', '4', 'O', '6', 'X', '8', 'O'});
        //GameBoard board = new GameBoard();


        Random rand = new Random();

        TicTacToeStrategy strategy = new TicTacToeStrategy(board){
            @Override
            public int getBestMove() {
                return 0;
            }

        };

    int result = strategy.getRandomMove();
      //  boolean open = board.isSquareOpen(1);

    }

}