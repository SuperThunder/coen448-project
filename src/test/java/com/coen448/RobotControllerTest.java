package com.coen448;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotControllerTest {

    RobotController robotController = new RobotController();
    @BeforeEach
    void setUp() {
        robotController.executeCommands("i 10");
        robotController.printInstructions();
        robotController.printPosition();
    }


    @Test
    void checkInitialize(){
        //Initialize
        assertEquals(10, robotController.getFloor().length);
    }

    @Test
    void penDown(){
        robotController.executeCommands("d");
        assertEquals("DOWN", robotController.getPenState());
    }

    @Test
    void penUP(){
        robotController.executeCommands("u");
        assertEquals("UP", robotController.getPenState());
    }

    @Test
    void printFloor(){
        robotController.executeCommands("p");
    }

    @Test
    void printPenState(){
        robotController.executeCommands("c");
    }

    @Test
    void invalidInput(){
        robotController.executeCommands("a");
    }

    @Test
    void movement(){
        robotController.executeCommands("d");
        assertEquals("DOWN", robotController.getPenState());

        robotController.executeCommands("m 4");
        assertTrue(robotController.canMoveForward(4));
        robotController.printPosition();

        robotController.executeCommands("r");
        assertEquals("EAST", robotController.getFacingDirection());

        robotController.executeCommands("m 5");
        assertTrue(robotController.canMoveForward(4));
        robotController.printPosition();

        robotController.executeCommands("l");
        assertEquals("NORTH", robotController.getFacingDirection());

        robotController.executeCommands("m 1");
        assertTrue(robotController.canMoveForward(1));

        robotController.executeCommands("l");
        assertEquals("WEST", robotController.getFacingDirection());

        robotController.executeCommands("m 5");
        assertFalse(robotController.canMoveForward(6));

        robotController.executeCommands("m 6");
        assertFalse(robotController.canMoveForward(6));

        robotController.executeCommands("r");
        robotController.executeCommands("r");
        robotController.executeCommands("r");
        assertEquals("SOUTH", robotController.getFacingDirection());

        robotController.executeCommands("m 6");
        assertTrue(robotController.canMoveForward(5));

        robotController.printPosition();
    }
}