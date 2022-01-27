package com.coen448;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputProcessorTest {

    @Test
    void MoveCommand() {
        for(int i = 1; i < 10; i++) {
            UserInputProcessor u = new UserInputProcessor("M " + Integer.toString(i));
            assertEquals(u.getCommand(), UserCommand.Move);
            assertEquals(u.getValue(), i);
        }

        //Test the lowercase version
        UserInputProcessor u = new UserInputProcessor("m 1");
        assertEquals(u.getCommand(), UserCommand.Move);
    }

    @Test
    void LeftCommand() {
        UserInputProcessor u = new UserInputProcessor("L");
        assertEquals(u.getCommand(), UserCommand.Left);

        u = new UserInputProcessor("l");
        assertEquals(u.getCommand(), UserCommand.Left);
    }

    @Test
    void RightCommand()
    {
        UserInputProcessor u = new UserInputProcessor("R");
        assertEquals(u.getCommand(), UserCommand.Right);

        u = new UserInputProcessor("r");
        assertEquals(u.getCommand(), UserCommand.Right);
    }

    @Test
    void PrintGridCommand()
    {
        UserInputProcessor u = new UserInputProcessor("P");
        assertEquals(u.getCommand(), UserCommand.PrintGrid);

        u = new UserInputProcessor("p");
        assertEquals(u.getCommand(), UserCommand.PrintGrid);
    }

    @Test
    void InitializeCommand()
    {
        for(int i = 1; i < 10; i++) {
            UserInputProcessor u = new UserInputProcessor("I " + Integer.toString(i));
            assertEquals(u.getCommand(), UserCommand.Initialize);
            assertEquals(u.getValue(), i);
        }

        UserInputProcessor u = new UserInputProcessor("i 1");
        assertEquals(u.getCommand(), UserCommand.Initialize);
    }

    @Test
    void UpCommand()
    {
        UserInputProcessor u = new UserInputProcessor("U");
        assertEquals(u.getCommand(), UserCommand.Up);

        u = new UserInputProcessor("u");
        assertEquals(u.getCommand(), UserCommand.Up);
    }

    @Test
    void DownCommand()
    {
        UserInputProcessor u = new UserInputProcessor("D");
        assertEquals(u.getCommand(), UserCommand.Down);

        u = new UserInputProcessor("d");
        assertEquals(u.getCommand(), UserCommand.Down);
    }

    @Test
    void PrintPen()
    {
        UserInputProcessor u = new UserInputProcessor("C");
        assertEquals(u.getCommand(), UserCommand.PrintPen);

        u = new UserInputProcessor("c");
        assertEquals(u.getCommand(), UserCommand.PrintPen);
    }

    @Test
    //M or I command but without a number following
    void MorINoNumber()
    {
        UserInputProcessor u = new UserInputProcessor("M k");
        assertEquals(u.getCommand(), UserCommand.Invalid);

        u = new UserInputProcessor("I k");
        assertEquals(u.getCommand(), UserCommand.Invalid);

        u = new UserInputProcessor("M -");
        assertEquals(u.getCommand(), UserCommand.Invalid);

        u = new UserInputProcessor("M");
        assertEquals(u.getCommand(), UserCommand.Invalid);

        u = new UserInputProcessor("M ");
        assertEquals(u.getCommand(), UserCommand.Invalid);

        u = new UserInputProcessor("M  ");
        assertEquals(u.getCommand(), UserCommand.Invalid);
    }

    @Test
    void MorIZeroNumber()
    {
        UserInputProcessor u = new UserInputProcessor("I 0");
        assertEquals(u.getCommand(), UserCommand.Invalid);
    }

    @Test
    void MorINegativeNumber()
    {
        for(int i = 1; i < 10; i++) {
            UserInputProcessor u = new UserInputProcessor("I -" + Integer.toString(i));
            assertEquals(u.getCommand(), UserCommand.Invalid);
        }
    }

    @Test
    void NumberInputFirstToken()
    {
        UserInputProcessor u = new UserInputProcessor("4");
        assertEquals(u.getCommand(), UserCommand.Unknown);
    }

    @Test
    void NonCommandLetters()
    {
        UserInputProcessor u = new UserInputProcessor("h");
        assertEquals(u.getCommand(), UserCommand.Unknown);
    }

    @Test
    void NoInputCommand()
    {
        UserInputProcessor u = new UserInputProcessor("");
        assertEquals(u.getCommand(), UserCommand.Unknown);

        u = new UserInputProcessor("  ");
        assertEquals(u.getCommand(), UserCommand.Unknown);

        u = new UserInputProcessor("   ");
        assertEquals(u.getCommand(), UserCommand.Unknown);
    }
}