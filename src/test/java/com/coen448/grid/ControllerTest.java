package com.coen448.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ControllerTest {
    Controller controller;

    @BeforeEach
    @DisplayName("Initializing Controller for Testing")
    void setUp() throws Exception {
        controller = new Controller();
        controller.initialize(10);
    }

    @Test
    @DisplayName("Initialize Controller Testing")
    void initialize() throws Exception {
        //Asserts that floor is NxN
        for (int i = 1; i < 10; i++) {
            Controller controller = new Controller();
            controller.initialize(i);
            //Asserts Columns
            assertEquals(i, controller.getRobot().getFloor().getFloor().size());
            //Asserts Rows
            assertEquals(i, controller.getRobot().getFloor().getFloor().get(i - 1).size());
        }
        //Asserts size less than 1
        Exception exception = Assertions.assertThrowsExactly(Exception.class, () -> controller.initialize(0)
                , "Board size has to be an integer larger than 0");
        Assertions.assertEquals("Board size has to be an integer larger than 0", exception.getMessage());
    }

    @Test
    @DisplayName("Robot Moving Test")
    void move() throws Exception {
        Boolean isDrawn;

        //================ North ==================

        //Move 0 cells
        controller.initialize(10);
        controller.move(0);
        assertEquals(0, controller.getRobot().getPen().getCurrentPos()[0]);

        //Move regular Integer cells
        controller.initialize(10);
        controller.move(2);
        assertEquals(2, controller.getRobot().getPen().getCurrentPos()[0]);

        //Move over length N cells
        controller.initialize(10);
        controller.move(13);
        assertEquals(9, controller.getRobot().getPen().getCurrentPos()[0]);

        //Move with Pen Down
        controller.initialize(10);
        controller.down();
        controller.move(2);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(0);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(1).get(0);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(2).get(0);
        assertEquals(Boolean.TRUE, isDrawn);

        //================ EAST ==================

        //Move 0 cells
        controller.initialize(10);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(0);
        assertEquals(0, controller.getRobot().getPen().getCurrentPos()[1]);

        //Move regular Integer cells
        controller.initialize(10);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(2);
        assertEquals(2, controller.getRobot().getPen().getCurrentPos()[1]);

        //Move over length N cells
        controller.initialize(10);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(13);
        assertEquals(9, controller.getRobot().getPen().getCurrentPos()[1]);

        //Move with Pen Down
        controller.initialize(10);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.down();
        controller.move(2);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(0);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(1);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(2);
        assertEquals(Boolean.TRUE, isDrawn);

        //================ South ==================

        //Move 0 cells
        controller.initialize(10);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.SOUTH);
        controller.move(0);
        assertEquals(2, controller.getRobot().getPen().getCurrentPos()[0]);

        //Move regular Integer cells
        controller.initialize(10);
        controller.move(9);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.SOUTH);
        controller.move(5);
        assertEquals(4, controller.getRobot().getPen().getCurrentPos()[0]);

        //Move over length N cells
        controller.initialize(10);
        controller.move(9);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.SOUTH);
        controller.move(13);
        assertEquals(0, controller.getRobot().getPen().getCurrentPos()[0]);

        //Move with Pen Down
        controller.initialize(10);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.SOUTH);
        controller.down();
        controller.move(2);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(0);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(1).get(0);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(2).get(0);
        assertEquals(Boolean.TRUE, isDrawn);


        //================ West ==================

        //Move 0 cells
        controller.initialize(10);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.WEST);
        controller.move(0);
        assertEquals(2, controller.getRobot().getPen().getCurrentPos()[1]);

        //Move regular Integer cells
        controller.initialize(10);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(6);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.WEST);
        controller.move(3);
        assertEquals(3, controller.getRobot().getPen().getCurrentPos()[1]);

        //Move over length N cells
        controller.initialize(10);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(6);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.WEST);
        controller.move(13);
        assertEquals(0, controller.getRobot().getPen().getCurrentPos()[1]);

        //Move with Pen Down
        controller.initialize(10);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.EAST);
        controller.move(2);
        controller.getRobot().getPen().setCurrentDir(Pen.Direction.WEST);
        controller.down();
        controller.move(2);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(0);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(1);
        assertEquals(Boolean.TRUE, isDrawn);
        isDrawn = controller.getRobot().getFloor().getFloor().get(0).get(2);
        assertEquals(Boolean.TRUE, isDrawn);
    }

    @Test
    void left() throws Exception {
        Pen.Direction direction;

        // Going Left till it Returns to North
        controller.left();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.WEST, direction);

        controller.left();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.SOUTH, direction);

        controller.left();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.EAST, direction);

        controller.left();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.NORTH, direction);
    }

    @Test
    void right() throws Exception {
        Pen.Direction direction;

        // Going Left till it Returns to North
        controller.right();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.EAST, direction);

        controller.right();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.SOUTH, direction);

        controller.right();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.WEST, direction);

        controller.right();
        direction = controller.getRobot().getPen().getCurrentDir();
        assertEquals(Pen.Direction.NORTH, direction);
    }

    @Test
    void printGrid() {
        String gridDisplay = controller.printGrid();
        System.out.println(gridDisplay);
    }

    @Test
    void up() {
        controller.up();
        assertEquals(Pen.State.UP, controller.getRobot().getPen().getState());
    }

    @Test
    void down() {
        controller.down();
        assertEquals(Pen.State.DOWN, controller.getRobot().getPen().getState());
    }

    @Test
    void printPen() throws Exception {
        String pen;
        String print;
        //At position 0, 0
        pen = controller.printPen();
        print = String.format("Position: %d, %d - Pen: %s - Facing: %s \n",
                0, 0, Pen.State.UP.name(), Pen.Direction.NORTH.name());
        assertEquals(print, pen);


        // At position 3,4 facing east pen down
        controller.down();
        controller.move(4);
        controller.right();
        controller.move(3);
        pen = controller.printPen();
        print = String.format("Position: %d, %d - Pen: %s - Facing: %s \n",
                3, 4, Pen.State.DOWN.name(), Pen.Direction.EAST.name());
        assertEquals(print, pen);
    }
}