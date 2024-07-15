package com.liftwork.lift;

import com.liftwork.LiftApplication;

import java.util.Scanner;

public class LiftView {
    private LiftModule liftModule;

    public LiftView() {
        liftModule = new LiftModule(this);
    }

    Scanner sc = new Scanner(System.in);


    public void init() {
        System.out.println("------------------------------------------------");
        System.out.println("App Name ----->" + LiftApplication.getInstance().getAppName());
        System.out.println("App Version -------->" + LiftApplication.getInstance().getAppVersion());
        System.out.println("----------------------------------------------------");
        menu();
    }

    public void menu() {
        int ch;
        do {
            System.out.println("Lift Controller");
            System.out.println("1.AddFloors");
            System.out.println("2.Show Lifts");
            System.out.println("3.Assign Lift");
            System.out.println("4.Restricted Floors");
            System.out.println("5. Change Lift Status");
            System.out.println("6.Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    addFloorsLift();
                    break;
                }
                case 2: {
                    liftModule.showLift();
                    break;
                }
                case 3: {
                    assignLift();
                    break;
                }
                case 4: {
                    restrictFloors();
                    break;
                }
                case 5: {
                    availabilityCheck();
                    break;
                }
                case 6: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Enter the Correct Menu:");
                    break;
                }
            }
        } while (ch > 5);

    }

    public void availabilityCheck() {
        System.out.println("Enter the Lift Id to Change Status:");
        int liftId = sc.nextInt();
        System.out.println("Status");
        System.out.println("1---> Active \n0 ---> Deactivate");
        int status = sc.nextInt();
        liftModule.checkAvailability(liftId, status);
    }

    public void addFloorsLift() {
        System.out.println("Enter the Lift Count:");
        int count = sc.nextInt();
        liftModule.addFloor(count);
    }

    public int getValue() {
        int ca = sc.nextInt();
        return ca;
    }


    public void assignLift() {
        int choice;
        do {
            System.out.print("Enter your current floor: ");
            int currFloor = sc.nextInt();
            System.out.print("Enter your destination floor: ");
            int destFloor = sc.nextInt();
            System.out.println("Enter the Person to Enter :");
            int people = sc.nextInt();
            liftModule.assignedLift(currFloor, destFloor, people);

            System.out.println("-----------------------------------------------------");
            System.out.println("Do you Want to Countiune Press 1: ");
            choice = sc.nextInt();
        } while (choice == 1);
        menu();
    }

    public void restrictFloors() {
        System.out.println("Lift Number");
        int liftId = sc.nextInt();
        System.out.println("Number of Floors What to Restrict:");
        int cnt = sc.nextInt();
        System.out.println("Floors:");
        liftModule.restrictFloorAdd(liftId, cnt);
    }

    public void showMessage(String msg, boolean newLine) {
        if (newLine) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }

    public void showMessage() {
        System.out.println();
    }
}
