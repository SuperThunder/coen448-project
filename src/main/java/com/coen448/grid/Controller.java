package com.coen448.grid;

public class Controller {
    private Robot robot;

//    public Controller() throws Exception {
//        this.robot = new Robot(new Floor(1));
//    }

    public void initialize(Integer size) throws Exception {
        Floor floor = new Floor(size);
        robot = new Robot(floor);
    }

    public void move(Integer s) {
        robot.move(s);
    }

    public void left() throws Exception {
        robot.turn('l');
    }

    public void right() throws Exception {
        robot.turn('r');
    }

    public void printGrid() {
        robot.printFloor();
    }

    public void up() {
        robot.getPen().setState(Pen.State.UP);
    }

    public void down() {
        robot.getPen().setState(Pen.State.DOWN);
    }

    public String printPen() {
        return robot.getPen().printPen();
    }

    public Robot getRobot() {
        return robot;
    }

}
