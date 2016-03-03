package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by KenN on 2/22/16.
 */
public class HumanPlayer extends Player {
    private int squareSelected;

    public HumanPlayer(String name,char marker) {
        super.name = name;
        super.gameMarker = marker;
    }


    public int getMove() {
        String keyboardInput;
        Boolean digits;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            keyboardInput = scanner.next();         //request input from user
            digits = keyboardInput.matches("\\d"); //must be numeric

            if (!digits) {
                System.out.println("Enter value 1 - 9");
            } else {
                squareSelected = Integer.parseInt(keyboardInput);
                if (squareSelected > 0 && squareSelected <= 9) {
                    break;
                } else System.out.println("Enter value 1 - 9");
            }
        }
        return squareSelected;
    }
}