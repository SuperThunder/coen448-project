package com.coen448;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class whiteboxtests {
    private RobotController robotController;

    @BeforeEach
    void init() {
        robotController = new RobotController();
        robotController.executeCommands("I 10");
    }

    @Test
    void input_I() {
        robotController.executeCommands("I ");
        robotController.executeCommands("i 5");
    }

    @Test
    void input_d() {
        robotController.executeCommands("d");
        assertEquals("DOWN", robotController.getPenState());
    }

    @Test
    void input_u() {
        robotController.executeCommands("u");
        assertEquals("UP", robotController.getPenState());
    }

    @Test
    void input_l() {
        robotController.executeCommands("l");
        assertEquals("WEST", robotController.getFacingDirection());
    }

    @Test
    void input_r() {
        robotController.executeCommands("r");
        assertEquals("EAST", robotController.getFacingDirection());
    }

    @Test
    void input_m() {
        robotController.executeCommands("m 5");
        robotController.executeCommands("c");
    }

    @Test
    void input_p() {
        robotController.executeCommands("d");
        robotController.executeCommands("m 5");
        robotController.executeCommands("p");
    }

    @Test
    void input_c() {
        robotController.executeCommands("I 10");
        robotController.executeCommands("c");
    }

    @Test
    void input_invalid() {
        robotController.executeCommands(";j;dlj;fl");
    }
//    @Test
//    void input_q()
//    {
//        robotController.executeCommands("q");
//    }
}

