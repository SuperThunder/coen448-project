package com.coen448.grid;

public class Controller {
    private Floor floor;
    private Robot robot;

    public void initialize(Integer size) throws Exception {
        floor = new Floor(size);
        robot = new Robot(floor);
    }

    public void move(Integer s){
        robot.move(s);
    }

    public void left() throws Exception {
        robot.turn('l');
    }

    public void right() throws Exception{
        robot.turn('r');
    }

    public void printGrid(){
        robot.printFloor();
    }

    public void up(){
        robot.getPen().setState(Pen.State.UP);
    }

    public void down(){
        robot.getPen().setState(Pen.State.DOWN);
    }

    public void printPen(){
        robot.getPen().printPen();
    }
}
