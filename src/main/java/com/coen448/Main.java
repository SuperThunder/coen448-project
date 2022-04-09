//COEN448 Project
//Alexander Wolfe 40103773
//Ahmed Ali 40102454

//Tools used:
//Java 11
//IntelliJ
//JUnit
//JCoco
//Trello: Project planning
//Google Sheets: Requirement tracking


package com.coen448;

import com.coen448.grid.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        System.out.println("COEN448 Project");

        List<String> command_history = new ArrayList<>();

        Scanner stdin = new Scanner(System.in);
        //INSTANTIATE GRID / ROBOT OBJECTS HERE
        Controller controller = new Controller();

        //Loop for user command input
        while (true) {
            //Get the input as a simple string to the end of the line
            System.out.println("Please enter a command: ");
            String input = stdin.nextLine();

            command_history.add(input);

            //Send that to a new processor object that tells us what kind of input we received
            UserInputProcessor userInput = new UserInputProcessor(input);

            if(userInput.getCommand() == UserCommand.Initialize || userInput.getCommand() == UserCommand.Move)
                logger.log(Level.INFO, "main got user command: " + userInput.getCommand().toString() + " " + userInput.getValue());
            else {
                logger.log(Level.INFO, "main got user command: " + userInput.getCommand().toString());
            }

            //CALL GRID / ROBOT CODE FROM HERE
            //Check what kind of input received
            switch (userInput.getCommand()) {
                //Move
                case Move:
                    controller.move(userInput.getValue());
                    break;

                //Left
                case Left:
                    controller.left();
                    break;

                //Right
                case Right:
                    controller.right();
                    break;

                //Print the grid
                case PrintGrid:
                    controller.printGrid();
                    break;

                //Initialize
                case Initialize:
                    controller.initialize(userInput.getValue());
                    break;

                //Up (pen)
                case Up:
                    controller.up();
                    break;

                //Down (pen)
                case Down:
                    controller.down();
                    break;

                //Print pen position and status, robot facing direction
                case PrintPen:
                    System.out.println(controller.printPen());
                    break;

                //Stop Program
                case Stop:
                    System.exit(0);
                    break;

                //Unknown command
                case Unknown:
                    break;

                //Replay all commands entered by the user as a history
                case Replay:
                    System.out.println("Command history:");
                    for(String el: command_history)
                    {
                        System.out.println(el);
                    }

                //Known command with invalid parameter
                case Invalid:
                    break;

                default:
                    break;
            }
        }
    }
}
