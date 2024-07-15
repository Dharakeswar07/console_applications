package com.liftwork.lift;

import java.util.ArrayList;

import Lift.src.com.liftwork.models.Lift;

public class LiftModule {
    private LiftView lv;
    ArrayList<Lift> liftList = new ArrayList<>();

    public LiftModule(LiftView liftView) {
        lv = liftView;
    }


    public void checkAvailability(int liftId, int status) {
        if (status > 1) {
            lv.showMessage("Please Enter the Status Correctly",true);
            lv.availabilityCheck();
        }
        for (Lift i : liftList) {
            if (i.getLiftId() == liftId) {
                i.setAvailability(status);
            }
        }
        showLift();
    }

    public void addFloor(int count) {
        if (liftList.isEmpty()) {
            for (int i = 1; i <= count; i++) {
                Lift Lift1 = new Lift();
                Lift1.setLiftId(i);
                lv.showMessage("Lift "+ i +" Capacity of the Lift :",true);
                int ca = lv.getValue();
                Lift1.setCapacity(ca);
                Lift1.setCurrentFloor(0);
                Lift1.setAvailability(1);
                liftList.add(Lift1);
            }
        } else {

            for (int i = liftList.size() + 1; i <= liftList.size() + count; i++) {
                Lift Lift1 = new Lift();
                Lift1.setLiftId(i);
                lv.showMessage("Lift "+ i +" Capacity of the Lift :",true);
                int ca = lv.getValue();
                Lift1.setCapacity(ca);
                Lift1.setCurrentFloor(0);
                liftList.add(Lift1);
                count--;
            }
        }
        lv.showMessage("All Lift Has been Set to 0 Floor",true);
        lv.menu();
    }

    public void showLift() {
        lv.showMessage("-------------------------------------------------------------",true);
        lv.showMessage("Lift\t |\t Floor\t\t | Capacity\t\t  | Status | ",true);

        for (Lift i : liftList) {
            lv.showMessage("L" + i.getLiftId() + "\t\t|\t\t" + i.getCurrentFloor() + "\t\t|\t\t" + i.getCapacity() + "\t\t\t |" + i.getAvailability(),true);
        }
        lv.showMessage("-------------------------------------------------------------",true);
        lv.menu();
    }

    public void assignedLift(int currFloor, int destFloor, int people) {
        int min = Integer.MAX_VALUE;
        int assignedLift = -1;
        boolean check;
        for (Lift lift : liftList) {
            check = true;

            ArrayList<Integer> resFloor = lift.getRestrictLiftFloor();

            if (resFloor.isEmpty() || !(resFloor.contains(currFloor) || resFloor.contains(destFloor)) && lift.getCapacity() >= people && lift.getAvailability() == 1) {

                int requiredFloor = Math.abs(lift.getCurrentFloor() - currFloor);
                if (requiredFloor <= min) {
                    if (requiredFloor == min) {
                        if (assignedLift == lift.getCurrentFloor()) {
                            continue;
                        }
                        min = requiredFloor;
                    } else {
                        min = requiredFloor;
                        assignedLift = lift.getLiftId();
                    }
                }
            }
        }
        lv.showMessage("----------------------------------------------------------------",true);
        lv.showMessage("Lift Assigned to the User is: " + assignedLift,true);
        lv.showMessage("----------------------------------------------------------------",true);
        for (Lift i : liftList) {
            if (i.getLiftId() == assignedLift) {
                i.setCurrentFloor(destFloor);
            }
        }
        for (Lift i : liftList) {
            lv.showMessage("L" + i.getLiftId() + " : " + i.getCurrentFloor(),true);
        }
    }

    public void restrictFloorAdd(int liftId, int cnt) {
        ArrayList<Integer> restrictFloors = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int fl = lv.getValue();
            restrictFloors.add(fl);
        }
        for (Lift i : liftList) {
            if (i.getLiftId() == liftId) {
                i.setRestrictLiftFloor(restrictFloors);
            }
        }
        lv.showMessage("Restrict Floor List for Each Lifts:",true);
        for (Lift i : liftList) {
            lv.showMessage("L" + i.getLiftId() + " : " + i.getCurrentFloor(),true);
            ArrayList<Integer> ast = i.getRestrictLiftFloor();
            if (!ast.isEmpty()) {
                lv.showMessage(" : Restrict Floor : {",false);
                for (int j : ast) {
                    lv.showMessage(j + ",",false);
                }
                lv.showMessage("}",false);
            } else {
                lv.showMessage(" : Restricted Floor : {}",false);
            }
            lv.showMessage();
        }
        lv.menu();
    }
}
