package edu.htc.tictactoe.player;

import edu.htc.tictactoe.strategy.*;
import edu.htc.tictactoe.TicTacToe;


/**
 * Created by KenN on 2/22/16.
 */
public class ComputerPlayer extends Player{
    private int answer = 1;

    public ComputerPlayer(String name,char marker) {
        super.name = name;
        super.gameMarker = marker;
    }

    public int getMove(){   //process computer play
        char human;
        human=TicTacToe.getOpponentMark(super.gameMarker); //returns opposite mark

        switch (TicTacToe.levelOfPlay){
            //case 1 is human vs human
            case 2:
                TicTacToeStrategy strategy = new RandomMoveStrategy();
                answer = strategy.getBestMove(); //get random move for computer
                break;
            case 3:
                strategy = new BestOpenMoveStrategy();
                answer = strategy.getBestMove(); //get best open for computer
                break;
            case 4:
                strategy = new BlockWinStrategy();
                answer = strategy.getBestMove(human); //get move for computer that blocks any win
                if (answer == -1) { //-1 means previous step failed
                    TicTacToeStrategy strategy2 = new BestOpenMoveStrategy();
                    answer = strategy2.getBestMove(); //get best open for computer
                }
                break;
            case 5:
                strategy = new GoForWinStrategy();
                answer = strategy.getBestMove(super.gameMarker); //get move for computer that finds win
                if (answer == -1){ //-1 means previous step failed
                    strategy = new BlockWinStrategy();
                    answer = strategy.getBestMove(human); //get best open move for computer
                }
                if (answer == -1) { //-1 means previous step failed
                    TicTacToeStrategy strategy2 = new BestOpenMoveStrategy();
                    answer = strategy2.getBestMove(); //get best open move for computer
                }
                break;

            default:
                strategy = new RandomMoveStrategy();
                answer = strategy.getBestMove(); //get best open move for computer
                break;

        }
        if (TicTacToe.DEBUG_MESSAGES){
            System.out.println("Computer selects " + answer);
        }

        return answer;
    }
}