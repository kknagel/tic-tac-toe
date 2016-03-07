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
//    public int getBestMove(char playerMark){
//
//    }


    public int getBestMove() {       //find best open move
        int result = 0;

        result = super.getBestOpenMove();

//        int x;
//        //first take center 5
//        //next take corner 1, 3, 7, 9
//        //next any random 2, 4, 6, 8
//        ArrayList<Integer> odds = new ArrayList<Integer>();
//        ArrayList<Integer> evens = new ArrayList<Integer>();
//
//        //find all odds and evens
//        for (x = 0; x < GameBoard.openSquares.size(); x++) { //tried for each loop problem with index didn't start at 0
//            //System.out.println(openList.get(x));
//            if (GameBoard.openSquares.get(x) % 2 != 0) {
//                odds.add(GameBoard.openSquares.get(x));
//            } else evens.add(GameBoard.openSquares.get(x));
//        }
//        int oddSize = odds.size();
//        int evenSize = evens.size();
//
//        if (oddSize > 0){
//            if (GameBoard.isSquareOpen(5, "CPU")) {
//                result = 5;
//            } else {
//                result = super.getRandomMove(oddSize, 0);
//                    return  odds.get(result);
//                }
//        } else {
//            result = super.getRandomMove(evenSize, 0);
//            return evens.get(result);
//        }

        return result;
    }

    public int getBestMove(char playerMark){
        result = 0;
        return result;
    }
}