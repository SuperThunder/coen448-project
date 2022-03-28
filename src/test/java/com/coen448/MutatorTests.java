package com.coen448;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MutatorTests {

    private RobotController robotController;

    @BeforeEach
    void init()
    {
        robotController = new RobotController();
        robotController.executeCommands("I 10");
        robotController.executeCommands("M 3");
        robotController.executeCommands("R");
        robotController.executeCommands("M 3");
    }

    @Test
    //Face north then test moving for valid and nonvalid situations
    void canmoveforward_north()
    {
        robotController.executeCommands("L");
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
        assertFalse(robotController.canMoveForward(10));
        assertEquals(robotController.getFacingDirection(), "NORTH");
    }

    @Test
    //Face south then test moving
    void canmoveforward_south()
    {
        robotController.executeCommands("R");
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
        assertFalse(robotController.canMoveForward(10));
        assertEquals(robotController.getFacingDirection(), "SOUTH");
    }

    @Test
    void canmoveforward_west()
    {
        robotController.executeCommands("L");
        robotController.executeCommands("L");
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
        assertFalse(robotController.canMoveForward(10));
        assertEquals(robotController.getFacingDirection(), "WEST");
    }

    @Test
    void canmoveforward_east()
    {
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
        assertFalse(robotController.canMoveForward(10));
        assertEquals(robotController.getFacingDirection(), "EAST");
    }
}
