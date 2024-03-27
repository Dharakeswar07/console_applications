package com.librarymanagement.librarysetup;

import java.util.Scanner;

public class LibrarySetupView {

    private LibrarySetupModule librarySetupModule;
    Scanner scanner = new Scanner(System.in);

    public LibrarySetupView() {
        librarySetupModule = new LibrarySetupModule(this);
    }

    public void init() {
        System.out.println("Register Your Library Get id For your Library\n\n");
        librarySetupModule.startSetUp();
    }
    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void initiateSetup() {

        System.out.println("\n\nLibrary Details");
        System.out.println("Enter the Library Name:");
        String libraryName = scanner.nextLine();
        System.out.println("Phone Number:");
        String phoneNo = scanner.nextLine();
        System.out.println("Email Id:");
        String emailId = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();
        librarySetupModule.libraryAdd(libraryName, phoneNo, emailId, address,0);

    }

    // public void editLibraryDetails() {
    //     System.out.println("\nEdit Library Details");
    //     System.out.println("Enter the Library ID:");
    //     int libraryId = scanner.nextInt();
    //     scanner.nextLine(); // Consume newline character
    //     librarySetupModule.getLibraryInfoById(libraryId);
    //     Library existingLibrary = LibraryDatabase.getInstance().getLibrary();
    //     if (existingLibrary != null && existingLibrary.getLibraryId() == libraryId) {
    //         System.out.println("Enter the New Library Name:");
    //         String newLibraryName = scanner.nextLine();
    //         System.out.println("Enter the New Phone Number:");
    //         String newPhoneNo = scanner.nextLine();
    //         System.out.println("Enter the New Email Id:");
    //         String newEmailId = scanner.nextLine();
    //         System.out.println("Enter the New Address:");
    //         String newAddress = scanner.nextLine();
    //         Library updatedLibrary = new Library(newLibraryName, newPhoneNo, newEmailId, newAddress);
    //         librarySetupModule.editLibrary(updatedLibrary);
    //     } else {
    //         System.out.println("Library with ID " + libraryId + " not found.");
    //     }
    // }


public void searchLibrary()
{
    System.out.println("\n Search Library Book's");
    System.out.println("Library Id");
    int libraryId=scanner.nextInt();
    scanner.nextLine();
    librarySetupModule.getLibraryInfoById(libraryId);
}

    // Method to delete library record
    public void deleteLibraryRecord() {
        System.out.println("\nDelete Library Record");
        System.out.println("Enter the Library ID:");
        int libraryId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        librarySetupModule.deleteLibraryById(libraryId);
    }

    // Method to show library record
    public void showLibraryRecord() {
        System.out.println("\nLibrary Record");
        librarySetupModule.showLibraryList();
    }
    
}
