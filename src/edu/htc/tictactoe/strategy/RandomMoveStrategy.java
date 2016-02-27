package edu.htc.tictactoe.strategy;


/**
 * Created by KenN on 2/25/16.
 */
public class RandomMoveStrategy extends TicTacToeStrategy{
    boolean error;

    public RandomMoveStrategy(){

    }

    public int getBestMove(){

        int result = super.getRandomMove(); //compputer plays 1-9

        return result;
    }

}
