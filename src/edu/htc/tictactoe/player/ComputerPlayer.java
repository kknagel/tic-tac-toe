package edu.htc.tictactoe.player;

import edu.htc.tictactoe.strategy.RandomMoveStrategy;
import edu.htc.tictactoe.strategy.TicTacToeStrategy;

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

        TicTacToeStrategy strategy = new RandomMoveStrategy();
        answer = strategy.getBestMove();

        return answer;
    }
}
