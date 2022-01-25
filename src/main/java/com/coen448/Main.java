//COEN448 Project
//Alexander Wolfe 40103773
//Ahmed Ali

//Tools used:
//Java 11
//IntelliJ
//JUnit
//JCoco
//Trello: Project planning
//Google Sheets: Requirement tracking


package com.coen448;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.out.println("COEN448 Project");

        Scanner stdin = new Scanner(System.in);
        //INSTANTIATE GRID / ROBOT OBJECTS HERE

        //Loop for user command input
        while(true) {
            //Get the input as a simple string to the end of the line
            System.out.println("Please enter a command:\n");
            String input = stdin.nextLine();

            //Send that to a new processor object that tells us what kind of input we received
            UserInputProcessor userinput = new UserInputProcessor(input);

            logger.log(Level.INFO, "main got user command: " + userinput.getCommand().toString());

            //CALL GRID / ROBOT CODE FROM HERE
            //Check what kind of input received
            switch(userinput.getCommand()) {
                //Move
                case Move:

                    break;

                //Left
                case Left:

                    break;

                //Right
                case Right:

                    break;

                //Print the grid
                case PrintGrid:

                    break;

                //Initialize
                case Initialize:

                    break;

                //Up (pen)
                case Up:

                    break;

                //Down (pen)
                case Down:

                    break;

                //Print pen position and status, robot facing direction
                case PrintPen:

                    break;

                //Stop Program
                case Stop:
                    System.exit(0);
                    break;

                //Unknown command
                case Unknown:
                    break;

                //Known command with invalid parameter
                case Invalid:
                    break;

                default:
                    break;
            }
        }
    }
}
