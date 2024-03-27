package com.librarymanagement.managecustomer;


import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;
import com.librarymanagement.home.HomeView;
import com.librarymanagement.validator.Validator;

public class ManageCustomerView {

    private ManageCustomerModel manageCustomerModel;
    Scanner scanner = new Scanner(System.in);

    public ManageCustomerView() {
        this.manageCustomerModel = new ManageCustomerModel(this);
    }

    public void customerInit() {
        do {
            LibraryManagement2024.getInstance().clear();
            System.out.println("\t\t\t\t Customer Manage");
            System.out.println("1. Customer Add");
            // System.out.println("2.Customer Edit");
            System.out.println("2. Customer List");
            System.out.println("3. Customer Delete");
            System.out.println("4. Back <--- <--");
            System.out.println("5. Logout");
            int n = scanner.nextInt();

            switch (n) {
                case 1: {
                    customerAdd();
                    break;
                }
                case 2: {
                    manageCustomerModel.customerListShow();
                    break;
                }
                case 3: {
                    deleteCustomerRecord();
                    break;
                }
                case 4: {
                    new HomeView().homeInit();
                    break;
                }
                case 5: {
            manageCustomerModel.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    public void customerAdd() {
        String name;
        String phoneNo;
        String email;
        String address;
        System.out.println("\t\t\t\t Customer Details");
        scanner.nextLine();
        Boolean valid;
        do {
            System.out.println("Customer Name:");
            name = scanner.nextLine();
            valid = Validator.isValidName(name);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid name.\u001B[0m");
            }
        } while (!valid);
        do {
            System.out.println("Phone No:");
            phoneNo = scanner.nextLine();
            valid = Validator.isValidPhoneNumber(phoneNo);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Phone No.\u001B[0m");
            }
        } while (!valid);
        do {
            System.out.println("Email Id:");
            email = scanner.nextLine();
            valid = Validator.isValidEmail(email);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Email.\u001B[0m");
            }
        } while (!valid);
        System.out.println("Address:");
        address = scanner.nextLine();
        manageCustomerModel.customerAdd(name, phoneNo, email, address);
    }

    // Method to delete library record
    public void deleteCustomerRecord() {
        System.out.println("\t\t\t\t Delete Customer Record");
        System.out.println("Enter the Customer ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        manageCustomerModel.deleteCustomer(customerId);  
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
