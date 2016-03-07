package edu.htc.tictactoe.strategy;

/**
 * Created by KenN on 2/27/16.
 */

import edu.htc.tictactoe.GameBoard;

import java.util.ArrayList;

public class BestOpenMoveStrategy extends TicTacToeStrategy {
    private int result;

    public BestOpenMoveStrategy(){
    }


    public int getBestMove() {       //find best open move
        int result = 0;

        result = super.getBestOpenMove();

        return result;
    }

    public int getBestMove(char playerMark){
        result = 0;
        return result;
    }
}