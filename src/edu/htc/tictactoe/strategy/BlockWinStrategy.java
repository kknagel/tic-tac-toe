package edu.htc.tictactoe.strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.ComputerPlayer;

/**
 * Created by Administrator on 3/3/16.
 */
public class BlockWinStrategy extends TicTacToeStrategy {

    public BlockWinStrategy(){

    }

//    public int getBestMove(){
//        int result=0;
//
//        return result;
//    }
//    public int getBestMove(char playerMark) {
//        //find best open move
//    }

    public int getBestMove() {       //find best open move
//        int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
//        int x,y, count;
//        int index=-1;
        int result = 0;
        //result = super.findWinFor(ComputerPlayer.gameMarker);
        //result = super.findWinFor(playerMark);





        return result;
    }
    public int getBestMove(char playerMark) {
//        int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
//        int x,y, count;
//        int index=-1;
        int result = 0;
        result = super.findWinFor(playerMark);


        return result;


    }

}
