package com.coen448;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserInputProcessor {
    private UserCommand com;
    private int com_value = -1;
    static Logger logger = Logger.getLogger(UserInputProcessor.class.getName());

    public UserInputProcessor(String inputline)
    {
        logger.log(Level.INFO, "UserInputProcessor constructor got input: " + inputline);

        processLine(inputline);

    }

    public UserCommand getCommand()
    {
        return com;
    }

    //Get value for Move and Initialize commands
    //Returns -1 for all other commands
    public int getValue()
    {
        return com_value;
    }

    //process the input line
    private void processLine(String inputline)
    {
        //process the string and set the com values
        //leading/trailing whitespace removed, all internal spaces replaced with single space
        String[] tokens = inputline.trim().replaceAll("\\s+", " ").split(" ");

        logger.log(Level.INFO, "Got tokens: " + String.join( " / ", tokens));

        //Check what kind of input received
        switch (tokens[0].toUpperCase()) {
            //Move
            case "M":
                com = UserCommand.Move;
                break;
            //Left
            case "L":
                com = UserCommand.Left;
                break;
            //Right
            case "R":
                com = UserCommand.Right;
                break;

            //Print the grid
            case "P":
                com = UserCommand.PrintGrid;
                break;

            //Initialize
            case "I":
                com = UserCommand.Initialize;
                break;

            //Up (pen)
            case "U":
                com = UserCommand.Up;
                break;

            //Down (pen)
            case "D":
                com = UserCommand.Down;
                break;

            //Print pen position and status, robot facing direction
            case "C":
                com = UserCommand.PrintPen;
                break;

            //Stop program
            case "Q":
                com = UserCommand.Stop;
                break;

            default:
                System.out.println("Error: Unknown command: " + tokens[0]);
                com = UserCommand.Unknown;
                return;
        }

        //Ignore anything after the 2nd token
        if(tokens.length > 2)
        {
            String[] extra_tokens = Arrays.copyOfRange(tokens, 2, tokens.length);
            System.out.println("Warn: Ignoring extra input \"" + String.join(" ", extra_tokens) + "\"");
        }

        //if a Move or Init command, set the command integer value too
        if(tokens[0].toUpperCase().equals("M") || tokens[0].toUpperCase().equals("I"))
        {
            //No second token for length encountered
            if(tokens.length <= 1)
            {
                System.out.println("Error: Expected non-negative integer parameter for " + tokens[0] + " command, none encountered");
                com = UserCommand.Invalid;
                return;
            }

            try
            {
                com_value = Integer.parseInt(tokens[1]);
                logger.log(Level.INFO, "Command int param: " + Integer.toString(com_value));
                if(com_value < 0)
                {
                    System.out.println("Error: Parameter to M or I must be positive: " + Integer.toString(com_value));
                    com = UserCommand.Invalid;
                    return;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Error: Invalid number for M or I: " + tokens[1]);
                com = UserCommand.Invalid;
                com_value = -1;
                return;
            }
        }
    }
}
