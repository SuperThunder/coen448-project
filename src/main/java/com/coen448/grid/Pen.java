package com.coen448.grid;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;

public class Pen {
    private final Integer[] currentPos;
    private State state;
    private Direction currentDir;
    private char arrow;
    private BiMap<Integer, Direction> directionMap;
    private HashMap<Pen.Direction, Character> directionArrows;

    public Pen() {
        initDirections();
        state = State.UP;
        currentDir = Direction.NORTH;
        currentPos = new Integer[]{0, 0};
        arrow = directionArrows.get(currentDir);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer[] getCurrentPos() {
        return currentPos;
    }

    public Direction getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

    public void setArrow(char arrow) {
        this.arrow = arrow;
    }

    public BiMap<Integer, Direction> getDirectionMap() {
        return directionMap;
    }

    public HashMap<Direction, Character> getDirectionArrows() {
        return directionArrows;
    }

    private void initDirections() {
        directionMap = HashBiMap.create();
        directionMap.put(1, Pen.Direction.NORTH);
        directionMap.put(2, Pen.Direction.EAST);
        directionMap.put(3, Pen.Direction.SOUTH);
        directionMap.put(4, Pen.Direction.WEST);

        directionArrows = new HashMap<>();
        directionArrows.put(Pen.Direction.NORTH, '\u2191');
        directionArrows.put(Pen.Direction.EAST, '\u2192');
        directionArrows.put(Pen.Direction.SOUTH, '\u2193');
        directionArrows.put(Pen.Direction.WEST, '\u2190');
    }

    public String printPen() {
        return String.format("Position: %d, %d - Pen: %s - Facing: %s \n",
                currentPos[1], currentPos[0], state.name(), currentDir.name());
    }


    protected enum State {
        UP,
        DOWN
    }

    protected enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

}
