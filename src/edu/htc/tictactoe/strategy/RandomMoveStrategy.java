package edu.htc.tictactoe.strategy;


import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.TicTacToe;

import java.util.ArrayList;

/**
 * Created by KenN on 2/25/16.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {
    boolean error;
    ArrayList<Integer> test = GameBoard.openSquares;

    public RandomMoveStrategy() {

    }

    public int getBestMove() {
        //ArrayList<Integer> os = GameBoard.openSquares
        //
        int result = super.getRandomMove(); //computer plays 1-9

        while (GameBoard.isSquareOpen(result, "CPU") == false){
            //System.out.println("square is taken " + result);
            result = super.getRandomMove(); //computer plays 1-9

        }

        return result;
    }

}
