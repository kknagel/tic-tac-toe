package edu.htc.tictactoe.player;

import edu.htc.tictactoe.strategy.*;
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
        char human;
        if (super.gameMarker == 'X'){
            human = 'O';
        } else human = 'X';

        switch (TicTacToe.levelOfPlay){
            case 2:
                TicTacToeStrategy strategy = new RandomMoveStrategy();
                answer = strategy.getBestMove(); //get move from computer
                break;
            case 3:
                strategy = new BestOpenMoveStrategy();
                answer = strategy.getBestMove(); //get move from computer
                break;
            case 4:
                strategy = new BlockWinStrategy();
                answer = strategy.getBestMove(human); //get move from computer that block any win / get best open
                if (answer == -1) {
                    TicTacToeStrategy strategy2 = new BestOpenMoveStrategy();
                    answer = strategy2.getBestMove(); //get move from computer
                }
                break;
            case 5:
                strategy = new GoForWinStrategy();
                answer = strategy.getBestMove(super.gameMarker); //get move from computer that block any win / get best open
                if (answer == -1){
                    strategy = new BlockWinStrategy();
                    answer = strategy.getBestMove(human); //get move from computer that block any win / get best open
                }
                if (answer == -1) {
                    TicTacToeStrategy strategy2 = new BestOpenMoveStrategy();
                    answer = strategy2.getBestMove(); //get move from computer
                }
                break;

            default:
                strategy = new RandomMoveStrategy();
                answer = strategy.getBestMove(); //get move from computer
                break;

        }
        if (TicTacToe.DEBUG_MESSAGES){
            System.out.println("Computer selects " + answer);
        }

        return answer;

    }
}