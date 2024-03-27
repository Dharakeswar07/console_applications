package com.interviewpanel.homepanel;

import java.util.Scanner;

import com.interviewpanel.adminlogin.AdminLoginView;
import com.interviewpanel.candidatemanagement.CandidateManagementView;
import com.interviewpanel.employeemanagement.EmployeeManagementView;
import com.interviewpanel.interviewpanel.InterviewPanelView;
import com.interviewpanel.models.SessionStore;

public class HomeView {


    private HomeModule homeModule;

Scanner sc=new Scanner(System.in);
    public HomeView()
    {
        this.homeModule=new HomeModule(this);

    }

    public void homeInit()
{
    homeModule.homeMenu();
}

    public  void adminMenu() {
        do {
            System.out.println("\n\t\t\t\t Interview Panel");
            System.out.println("1. Employee Management");
            System.out.println("2. Candidate Mangement");
            System.out.println("3. Interview Panel");
            System.out.println("4. Logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    new EmployeeManagementView().empInit();
                    break;
                }
                case 2: {
                    new CandidateManagementView().candidateInit();
                    break;
                }
                case 3: {
                    new InterviewPanelView().interviewPanelInit();
                    break;
                }
                case 4: {
                    System.out.println("Your Id Is Logout");
                    new AdminLoginView().loginInit();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    public  void employeeMenu() {
        do {
            System.out.println("\n\t\t\t\t Interview Panel");
            System.out.println("1. Candidate Mangement");
            System.out.println("2. Interview Panel");
            System.out.println("3. Logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    new CandidateManagementView().candidateInit();
                    break;
                }
                case 2: {
                    new InterviewPanelView().interviewPanelInit();
                    break;
                }
                case 3: {
                homeModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }


    public void showMessage(String s) {
        System.out.println(s);
    }
}


