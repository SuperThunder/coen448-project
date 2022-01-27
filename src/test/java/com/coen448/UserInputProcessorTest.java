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
    }

    @Test
    void LeftCommand() {
    }

    @Test
    void RightCommand()
    {

    }

    @Test
    void PrintGridCommand()
    {

    }

    @Test
    void InitializeCommand()
    {
        for(int i = 1; i < 10; i++) {
            UserInputProcessor u = new UserInputProcessor("I " + Integer.toString(i));
            assertEquals(u.getCommand(), UserCommand.Initialize);
            assertEquals(u.getValue(), i);
        }
    }

    @Test
    void UpCommand()
    {

    }

    @Test
    void DownCommand()
    {

    }

    @Test
    void PrintPen()
    {

    }

    @Test
    void MorINoNumber()
    {

    }

    @Test
    void MorINegativeNumber()
    {

    }

    @Test
    void NumberInputFirstToken()
    {

    }

    @Test
    void NonCommandLetters()
    {

    }

    @Test
    void NoInputCommand()
    {

    }
}