package edu.htc.tictactoe.strategy;


/**
 * Created by Administrator on 3/3/16.
 */
public class BlockWinStrategy extends TicTacToeStrategy {

    public BlockWinStrategy(){
    }

    public int getBestMove() {       //find best open move

        int result = 0;

        return result;
    }
    public int getBestMove(char playerMark) {

        int result = 0;
        result = super.findWinFor(playerMark);

        return result;

    }

}
