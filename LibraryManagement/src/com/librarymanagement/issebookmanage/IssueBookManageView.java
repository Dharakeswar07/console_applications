package com.librarymanagement.issebookmanage;

import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;
import com.librarymanagement.home.HomeView;

public class IssueBookManageView {

    private IssueBookManageModule issueBookManageModule;

    private Scanner sc = new Scanner(System.in);

    public IssueBookManageView() {
        issueBookManageModule = new IssueBookManageModule(this);
    }

    public void issueBookInit() {
        do {
            LibraryManagement2024.getInstance().clear();
            System.out.println("\t\t\t\t Issue Book Manage");
            System.out.println("1. Issue Book");
            System.out.println("2. Issue List");
            System.out.println("3. Overdue List");
            System.out.println("4. Return Book");
            System.out.println("5. Back <-- <-- ");
            System.out.println("6. Logout");
            System.out.println("Enter Your Choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    issueBook();
                    break;
                }
                case 2: {
                    showIssueList();
                    break;
                }
                case 3: {
                    showOverdueList();
                    break;
                }
                case 4: {
                    returnBook();
                    break;
                }
                case 5: {
                    new HomeView().homeInit();
                    break;
                }
                case 6: {
                    issueBookManageModule.logout();
                    return;
                }
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (true);
    }

    private void issueBook() {
        LibraryManagement2024.getInstance().clear();
        System.out.println("\t\t\t Book Details");
        System.out.println("Book ID:");
        int bookId = sc.nextInt();
       if(issueBookManageModule.checkBookById(bookId))
       {
           System.out.println("Enter Customer ID:");
           int customerId = sc.nextInt();
           if(issueBookManageModule.checkCustomerById(customerId))
           {
               issueBookManageModule.addIssueBooks(bookId, customerId, "Pending");
           }
       }
    }
    

    private void showIssueList() {
        // Retrieve and display the list of issued books
        issueBookManageModule.showIssuedBooksList();
    }

    private void showOverdueList() {
        System.out.println("Overdue Books:");
        issueBookManageModule.overdueBooksList();
       
    }

    private void returnBook() {
        System.out.println("Issue Id:");
        int issueId = sc.nextInt();
        issueBookManageModule.getbookById(issueId);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }

}
