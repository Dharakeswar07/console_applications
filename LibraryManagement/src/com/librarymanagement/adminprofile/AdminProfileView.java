package com.librarymanagement.adminprofile;


import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;
import com.librarymanagement.validator.Validator;


public class AdminProfileView {

    Scanner sc=new Scanner(System.in);
private AdminProfileModule adminProfileModule;


public AdminProfileView() {
    adminProfileModule=new AdminProfileModule(this);
}

public void adminProfileinit() {
    LibraryManagement2024.getInstance().clear();
    String name;
    String phoneNo;
    String email;
    String address;
    String userName;
    String password;
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("\t\t\t\t Admin Profile");
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

    System.out.println("Address:");
    address = sc.nextLine();
    System.out.println("\t\t\t\t Account Details");
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

    adminProfileModule.addProfileCreditantials(name, phoneNo, email, address, userName, password, "Admin");
}
public void showAdminDetails()
{
    adminProfileModule.showAdminDetails();
}
public void showMessage(String message)
{
System.out.println(message);
}

}
