package edu.htc.tictactoe.player;

import edu.htc.tictactoe.TicTacToe;
import edu.htc.tictactoe.UserInput;

import java.util.Scanner;

/**
 * Created by KenN on 2/22/16.
 */
public class HumanPlayer extends Player {
    private int squareSelected;

    public HumanPlayer(String name, char marker) {
        super.name = name;
        super.gameMarker = marker;
    }

    public int getMove() {
        int keyboardInput = 0;

        keyboardInput = UserInput.getUserNumericResponse("",1,9);

        return keyboardInput;
    }
}