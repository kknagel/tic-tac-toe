package edu.htc.tictactoe.player;

import edu.htc.tictactoe.strategy.BestOpenMoveStrategy;
import edu.htc.tictactoe.strategy.RandomMoveStrategy;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;
import edu.htc.tictactoe.TicTacToe;


/**
 * Created by KenN on 2/22/16.
 */
public class ComputerPlayer extends Player{
    int answer = 1;

    public ComputerPlayer(String name,char marker) {
        super.name = name;
        super.gameMarker = marker;
    }

    public int getMove(){

        switch (TicTacToe.levelOfPlay){
            case 1:
                TicTacToeStrategy strategy = new RandomMoveStrategy();
                answer = strategy.getBestMove(); //get move from computer
                break;
            case 2:
                strategy = new BestOpenMoveStrategy();
                answer = strategy.getBestMove(); //get move from computer
                break;
            case 3:

            case 4:

            default:
                strategy = new RandomMoveStrategy();
                answer = strategy.getBestMove(); //get move from computer
                break;

        }

        return answer;
    }
}