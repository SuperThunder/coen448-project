package com.coen448.grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ControllerNPETest {
    Controller controller = new Controller();

    public ControllerNPETest() throws Exception {
    }

    @Test
    @DisplayName("printGrid NPE")
    void printGrid() {
        controller.printGrid();

    }

    @Test
    @DisplayName("printPen NPE")
    void printPen() {
        controller.printPen();

    }

    @Test
    @DisplayName("right NPE")
    void right() throws Exception {
        controller.right();

    }

    @Test
    @DisplayName("left NPE")
    void left() throws Exception {
        controller.left();

    }

    @Test
    @DisplayName("up NPE")
    void up() {
        controller.up();

    }

    @Test
    @DisplayName("down NPE")
    void down() {
        controller.down();

    }

    @Test
    @DisplayName("getRobot NPE")
    void getRobot() {
        Robot robot=controller.getRobot();
        assertNotEquals(robot,null);

    }
    @Test
    @DisplayName("move NPE")
    void move() {
        controller.move(1);
    }


}
