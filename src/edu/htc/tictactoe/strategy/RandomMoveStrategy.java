package edu.htc.tictactoe.strategy;


import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.TicTacToe;

/**
 * Created by KenN on 2/25/16.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {

    public RandomMoveStrategy() {

    }

    public int getBestMove() {

        int result = super.getRandomMove(9, 1); //computer plays 1-9

        while (GameBoard.isSquareOpen(result, "CPU") == false){
            if (TicTacToe.DEBUG_MESSAGES) {
                System.out.println("Square is taken " + result);
            }
            result = super.getRandomMove(9, 1); //computer plays 1-9
        }

        return result;
    }

    public int getBestMove(char playerMark){
        int result = 0;
        return result;
    }

}