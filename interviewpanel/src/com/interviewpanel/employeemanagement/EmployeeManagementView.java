package com.interviewpanel.employeemanagement;

import java.util.Scanner;

import com.interviewpanel.adminlogin.AdminLoginView;
import com.interviewpanel.homepanel.HomeView;
import com.interviewpanel.models.Creditantials;
import com.interviewpanel.models.Employee;
import com.interviewpanel.validator.Validator;

public class EmployeeManagementView {

    private EmployeeManagementModule employeeManagementModule;
Scanner sc=new Scanner(System.in);
    public EmployeeManagementView()
    {
        this.employeeManagementModule=new EmployeeManagementModule(this);
    }

    public void empInit()
    {
         do {
            System.out.println("\n\t\t\t\t Employee Details");
            System.out.println("1. Add Employee");
            System.out.println("2. Employee List");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee by Employee Id");
            System.out.println("5. Search Employee by Employee Name");
            System.out.println("6. Back <--- <--");
            System.out.println("7. logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    addEmployee();
                    break;
                }
                case 2: {
                   employeeManagementModule.empShowList();
                    break;
                }
                case 3: {
                    System.out.println("Delete Employee");
                    System.out.println("Enter the Employee Id(For Delete):");
                    int empsearchId = sc.nextInt();
                    employeeManagementModule.empDeleteById(empsearchId);
                    break;
                }
                case 4: {
                    System.out.println("Enter the Employee Id(For Search):");
                    int empsearchId = sc.nextInt();
                    employeeManagementModule.empGetById(empsearchId);
                    break;
                }
                case 5: {
                    sc.nextLine();
                    System.out.println("Enter the Employee Name:");
                    String empsearchName = sc.nextLine();
                    employeeManagementModule.empSearchGet(empsearchName);
                    break;
                }
                case 6: {
                    new HomeView().homeInit();
                    break;
                }
                case 7: {
employeeManagementModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    public void showMessage(String string) {
      System.out.println(string);
    }

    public void addEmployee()
    {

        sc.nextLine();
        String name;
        String phoneNo;
        String email;
        String userName;
        String password;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\t\t\t\t Employee Creation");
        Boolean valid;
        do {
            System.out.println("Name:");
            name = sc.nextLine();
            valid = Validator.isValidName(name);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid name.\u001B[0m");
            }
        } while (!valid);
        do {
            System.out.println("Phone No:");
            phoneNo = sc.nextLine();
            valid = Validator.isValidPhoneNumber(phoneNo);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Phone No.\u001B[0m");
            }
        } while (!valid);
        do {
            System.out.println("Email Id:");
            email = sc.nextLine();
            valid = Validator.isValidEmail(email);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Email.\u001B[0m");
            }
        } while (!valid);

        System.out.println("Location:");
        String location=sc.nextLine();
        System.out.println("Position:");
        System.out.println("1. Interviewer\n 2. Receptionist");
        int  positionType=sc.nextInt();
        String position=employeeManagementModule.positionSelect(positionType);
        System.out.println("\t\t\t\t Account Details");
        sc.nextLine();
        System.out.println("UserName:");
        userName = sc.nextLine();
        do {
            // Provide instructions for password validation
            System.out.println("Please enter a password that meets the following criteria:");
            System.out.println("\t- Must be at least 8 characters long");
            System.out.println("\t- Must contain at least one uppercase letter");
            System.out.println("\t- Must contain at least one lowercase letter");
            System.out.println("\t- Must contain at least one digit");
            System.out.println("\t- Can contain special characters such as @, #, $, etc.");
            System.out.println("Password:");
            password = sc.nextLine();

            valid = Validator.isValidPassword(password);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Password.\u001B[0m");
            }
        } while (!valid);
        employeeManagementModule.addEmployee(name, phoneNo, email, location, position, userName, password);
    }
}
