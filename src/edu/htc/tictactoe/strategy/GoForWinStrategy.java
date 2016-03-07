package edu.htc.tictactoe.strategy;

/**
 * Created by Administrator on 3/4/16.
 */
public class GoForWinStrategy extends TicTacToeStrategy{


    public int getBestMove(){
        int result = 0;

        return result;
    }

    public int getBestMove(char playerMark){
        int result = 0;

        result = super.findWinFor(playerMark);


        return result;

    }
}
