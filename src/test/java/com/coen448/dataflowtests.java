package com.coen448;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class dataflowtests {
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
    void cmf_east_dpu_oob()
    {
        robotController.printPosition();

        assertFalse(robotController.canMoveForward(15));
    }
    
    @Test
    void cmf_east_dpu_wb()
    {
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
    }

    @Test
    void cmf_west_dpu_oob()
    {
        robotController.executeCommands("R");
        robotController.executeCommands("R");
        robotController.printPosition();

        assertFalse(robotController.canMoveForward(15));
    }

    @Test
    void cmf_west_dpu_wb()
    {
        robotController.executeCommands("R");
        robotController.executeCommands("R");
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
    }

    @Test
    void cmf_north_dpu_oob()
    {
        robotController.executeCommands("L");
        robotController.printPosition();

        assertFalse(robotController.canMoveForward(15));
    }

    @Test
    void cmf_north_dpu_wb()
    {
        robotController.executeCommands("L");
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
    }

    @Test
    void cmf_south_dpu_oob()
    {
        robotController.executeCommands("R");
        robotController.printPosition();

        assertFalse(robotController.canMoveForward(15));
    }

    @Test
    void cmf_south_dpu_wb()
    {
        robotController.executeCommands("R");
        robotController.printPosition();

        assertTrue(robotController.canMoveForward(1));
    }

}
