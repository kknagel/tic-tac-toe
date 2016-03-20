package edu.htc.tictactoe;

import java.util.Scanner;

/**
 * Created by Administrator on 3/19/16.
 */
public class UserInput {

    public static String getPlayerName(String name) {

        System.out.println("Please enter name for " + name);  //get player name
        Scanner getName = new Scanner(System.in);
        name = getName.next().toUpperCase();

        return name;
    }

    public static char getUserResponse(String message, String[] values) { //get x/o or y/n response from user
        String answer;
        char result = ' ';

        System.out.println(message);
        Scanner getMarker = new Scanner(System.in);

        answer = getMarker.next();
        while (!answer.equalsIgnoreCase(values[0]) && !answer.equalsIgnoreCase(values[1])) {    //more shapes
            System.out.println("Sorry, you must enter either " + values[0] + " or " + values[1]);
            answer = getMarker.next();
        }
        result = answer.toUpperCase().charAt(0);

        return result;
    }

    public static int getUserNumericResponse(String message, int low, int high){
        int keyboardInput = 0;

        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter selection " + low + " - " + high);

            try {
                keyboardInput = Integer.parseInt(scanner.next());            //get size and catch string data
            } catch (NumberFormatException e) {
                System.out.println("Please enter a integer value " + low + " - " + high);
            } catch (Exception other) {
                System.out.println("Something else happened");
            }

        } while (keyboardInput < low || keyboardInput > high);

        return keyboardInput;
    }
}
