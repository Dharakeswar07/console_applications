package Lift.src.com.liftwork.models;

import java.util.ArrayList;

public class Lift {
    private ArrayList<Lift> Lift = new ArrayList<>();
    private int  liftId;
    private int currentFloor;
    private int capacity;
    private int availability;
    private ArrayList<Integer> restrictLiftFloor = new ArrayList<>();

    public ArrayList<Lift> getLift() {
        return Lift;
    }

    public void setLift(ArrayList<Lift> Lift) {
        this.Lift = Lift;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public ArrayList<Integer> getRestrictLiftFloor() {
        return restrictLiftFloor;
    }

    public void setRestrictLiftFloor(ArrayList<Integer> restrictLiftFloor) {
        this.restrictLiftFloor = restrictLiftFloor;
    }

    @Override
    public String toString() {
        return "LiftData{" +
                "restrictLiftFloorUpto=" + restrictLiftFloor +
                '}';
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}