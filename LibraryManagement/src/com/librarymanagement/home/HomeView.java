package com.librarymanagement.home;

import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;
import com.librarymanagement.issebookmanage.IssueBookManageView;
import com.librarymanagement.managebook.ManageBookView;
import com.librarymanagement.managecustomer.ManageCustomerView;
import com.librarymanagement.managelibrary.ManageLibraryView;


public class HomeView {

    Scanner sc=new Scanner(System.in);
    private HomeModule homeModule;
    public HomeView()
    {
this.homeModule=new HomeModule(this);
    }

    public void homeInit()
    {
        homeModule.startMenuGet();
    }
    public void adminMenu()
    {
        System.out.println("\t\t\t\t Main Menu");
        System.out.println("1. Library Manage");
        System.out.println("2. Book Manage");
        System.out.println("3. Customer Creation");
        System.out.println("4. Issue Book Manage");
/*        System.out.println("5. Export All Data");*/
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.println("Select the Option:");
        int n=sc.nextInt();
        switch (n) {
            case 1: {
                new ManageLibraryView().manageLibraryInit();
                break;
            }
            case 2: {
                new ManageBookView().init();
                break;
            }

            case 3: {
                new ManageCustomerView().customerInit();
                break;
            }
            case 4: {
                new IssueBookManageView().issueBookInit();
                break;
            }
/*            case 5: {
            homeModule.exportData();
            break;
            }*/
            case 5: {
                homeModule.logout();
                return;
            }
            case 6: {
                System.exit(0);
            }
            default:
                break;
        }

    }

    public void employeeMenu()
    {
        LibraryManagement2024.getInstance().clear();
        System.out.println("\t\t\t\t Main Menu");
        System.out.println("1. Book Manage");
        System.out.println("2. Customer Creation");
        System.out.println("3. Issue Book Manage");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.println("Select the Option:");
        int n=sc.nextInt();
        switch (n) {
            case 1: {
                new ManageBookView().init();
                break;
            }

            case 2: {
                new ManageCustomerView().customerInit();
                break;
            }
            case 3: {
                new IssueBookManageView().issueBookInit();
                break;
            }
            case 4: {
                homeModule.logout();
                return;
            }
            case 5: {
                System.exit(0);
            }
            default:
                break;
        }

    }


    public void showResult(String s) {
        System.out.println(s);
    }
}
