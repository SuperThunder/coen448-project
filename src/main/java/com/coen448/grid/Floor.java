package com.coen448.grid;
import java.util.ArrayList;

public class Floor {
    private ArrayList<ArrayList<Boolean>> floor;
    private final Integer size;

    public Floor(Integer size) throws Exception {
        this.size = size;
        if(size < 1) throw new Exception("Board size has to be an integer larger than 1");
        floor = new ArrayList<>(size);
        initFloor();
        System.out.println("Floor Initialized");
    }

    private void initFloor(){
        ArrayList<Boolean> temp;
        for (int i = 0; i < size; i++) {
            temp = new ArrayList<>();
            for (int j = 0;j < size; j++) {
                temp.add(Boolean.FALSE);
            }
            floor.add(temp);
        }
    }


    public ArrayList<ArrayList<Boolean>> getFloor() {
        return floor;
    }

    public void setFloor(ArrayList<ArrayList<Boolean>> floor) {
        this.floor = floor;
    }

    public Integer getSize() {
        return size;
    }




}
