package com.coen448.grid;


public class Robot {
    private Pen pen;
    private Floor floor;

    public Robot(Floor floor) {
        pen = new Pen();
        this.floor = floor;
    }

    public void move(Integer s) {
        boolean endOfPath = false;
        draw();
        while (s > 0) {
            if (endOfPath) {
                System.out.println("End of floor, cannot move " + s + " step(s)");
                break;
            } else {
                draw();
                switch (pen.getCurrentDir()) {
                    case NORTH:
                        if (pen.getCurrentPos()[0] < floor.getSize() - 1) {
                            pen.getCurrentPos()[0]++;
                        } else {
                            endOfPath = true;
                        }
                        break;
                    case EAST:
                        if (pen.getCurrentPos()[1] < floor.getSize() - 1) {
                            pen.getCurrentPos()[1]++;
                        } else {
                            endOfPath = true;
                        }
                        break;
                    case SOUTH:
                        if (pen.getCurrentPos()[0] > 0) {
                            pen.getCurrentPos()[0]--;
                        } else {
                            endOfPath = true;
                        }
                        break;
                    case WEST:
                        if (pen.getCurrentPos()[1] > 0) {
                            pen.getCurrentPos()[1]--;
                        } else {
                            endOfPath = true;
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + pen.getCurrentDir());
                }
                s--;
            }
        }
        draw();
    }

    public void turn(Character dir) throws Exception {
        int key = pen.getDirectionMap().inverse().get(pen.getCurrentDir());
        switch (dir) {
            case 'r':
            case 'R':
                if (key < 4) {
                    key++;
                    pen.setCurrentDir(pen.getDirectionMap().get(key));
                } else {
                    pen.setCurrentDir(pen.getDirectionMap().get(1));
                }
                break;
            case 'l':
            case 'L':
                if (key > 1) {
                    key--;
                    pen.setCurrentDir(pen.getDirectionMap().get(key));
                } else {
                    pen.setCurrentDir(pen.getDirectionMap().get(4));
                }
                break;
            default:
                throw new Exception("Turning direction is either Left or Right");
        }
        pen.setArrow(pen.getDirectionArrows().get(pen.getCurrentDir()));
    }

    private void draw() {
        if (pen.getState().equals(Pen.State.DOWN)) {
            floor.getFloor().get(pen.getCurrentPos()[0]).set(pen.getCurrentPos()[1], Boolean.TRUE);
            floor.setFloor(floor.getFloor());
        }
    }

    public void printFloor() {
        for (int i = floor.getSize() - 1; i >= 0; i--) {
            System.out.printf("%-4d", i);
            for (int j = 0; j < floor.getSize(); j++) {

                // To Print Arrow uncomment below code and comment lines 101-105
                /* if((i == pen.getCurrentPos()[0]) && (j == pen.getCurrentPos()[1])){
                    System.out.printf("%-4c", pen.getArrow());
                }else {
                    Boolean temp = floor.getFloor().get(i).get(j);
                    if (temp)
                        System.out.printf("%-4s", "*");
                    else
                        System.out.printf("%-4d", 0);
                }*/

                Boolean temp = floor.getFloor().get(i).get(j);
                if (temp)
                    System.out.printf("%-4s", "*");
                else
                    System.out.printf("%-4s", " ");


            }
            System.out.println();
        }

        System.out.printf("%4s", "");
        for (int i = 0; i < floor.getSize(); i++) {
            System.out.printf("%-4d", i);
        }

        System.out.println();
    }

    public Pen getPen() {
        return pen;
    }

}
