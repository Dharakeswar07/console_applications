package com.librarymanagement.managelibrary;

import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;
import com.librarymanagement.home.HomeView;
import com.librarymanagement.validator.Validator;

public class ManageLibraryView {

private ManageLibraryModule manageLibraryModule;

    Scanner sc = new Scanner(System.in);

    public ManageLibraryView() {
       this.manageLibraryModule=new ManageLibraryModule(this);
    }

    public void manageLibraryInit() {
        do {
            LibraryManagement2024.getInstance().clear();
            System.out.println("\t\t\t\t Library Setup Management");
            System.out.println("1. Add Library");
            // System.out.println("2.Edit");
            System.out.println("2. Library Search");
            System.out.println("3. Delete");
            System.out.println("4. Library List");
            System.out.println("5. Back <-- <-- ");
            System.out.println("6. Logout");
            System.out.println("Enter Your Choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    init();
                    break;
                }
                // case 2: {
                //     // librarySetupView.editLibraryDetails();
                //     break;
                // }
                case 2: {
                    searchLibrary();
                    break;
                }
                case 3: {
                    deleteLibraryRecord();
                    break;
                }
                case 4: {
                    showLibraryRecord();
                    break;
                }
                case 5: {
                    new HomeView().homeInit();
                    break;
                }
                case 6: {
manageLibraryModule.logout();
                    return;
                }
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (true);

    }


    public void init() {
        manageLibraryModule.startSetUp();
    }
    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void initiateSetup() {
        LibraryManagement2024.getInstance().clear();
        String libraryName;
        String phoneNo;
        String emailId;
        Boolean valid;
        System.out.println("\t\t\t\t Library Details");
        sc.nextLine();
        do{
            System.out.println("Library Name:");
            libraryName = sc.nextLine();
            valid= Validator.isValidName(libraryName);
            if(!valid)
            {
                System.out.println("\u001B[31mEnter the valid Library Name\u001B[31m");
            }
        }while(!valid);
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
            emailId = sc.nextLine();
            valid = Validator.isValidEmail(emailId);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Email.\u001B[0m");
            }
        } while (!valid);
        System.out.println("Address:");
        String address = sc.nextLine();
        System.out.println("\t\t\t\t Account Details");
        System.out.println("Username:");
        String userName=sc.nextLine();
        String password;
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
        manageLibraryModule.libraryAdd(libraryName, phoneNo, emailId, address,userName,password,"Employee");

    }

    // public void editLibraryDetails() {
    //     System.out.println("\nEdit Library Details");
    //     System.out.println("Enter the Library ID:");
    //     int libraryId = sc.nextInt();
    //     sc.nextLine(); // Consume newline character
    //     manageLibraryModule.getLibraryInfoById(libraryId);
    //     Library existingLibrary = LibraryDatabase.getInstance().getLibrary();
    //     if (existingLibrary != null && existingLibrary.getLibraryId() == libraryId) {
    //         System.out.println("Enter the New Library Name:");
    //         String newLibraryName = sc.nextLine();
    //         System.out.println("Enter the New Phone Number:");
    //         String newPhoneNo = sc.nextLine();
    //         System.out.println("Enter the New Email Id:");
    //         String newEmailId = sc.nextLine();
    //         System.out.println("Enter the New Address:");
    //         String newAddress = sc.nextLine();
    //         Library updatedLibrary = new Library(newLibraryName, newPhoneNo, newEmailId, newAddress);
    //         manageLibraryModule.editLibrary(updatedLibrary);
    //     } else {
    //         System.out.println("Library with ID " + libraryId + " not found.");
    //     }
    // }


public void searchLibrary()
{
    LibraryManagement2024.getInstance().clear();
    System.out.println("\t\t\t Search Library Book's");
    System.out.println("Library Id");
    int libraryId=sc.nextInt();
    sc.nextLine();
    manageLibraryModule.getLibraryInfoById(libraryId);
}

    // Method to delete library record
    public void deleteLibraryRecord() {
        LibraryManagement2024.getInstance().clear();
        System.out.println("\t\t\tDelete Library Record");
        System.out.println("Enter the Library ID:");
        int libraryId = sc.nextInt();
        sc.nextLine(); // Consume newline character
        manageLibraryModule.deleteLibraryById(libraryId);
    }

    // Method to show library record
    public void showLibraryRecord() {
        LibraryManagement2024.getInstance().clear();
        System.out.println("\t\t\t Library Record");
        manageLibraryModule.showLibraryList();
    }
}
