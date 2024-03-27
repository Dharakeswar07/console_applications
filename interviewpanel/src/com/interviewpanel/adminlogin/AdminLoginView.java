package com.interviewpanel.adminlogin;

import java.util.Scanner;

import com.interviewpanel.InterviewPanelHomePage;

public class AdminLoginView {


    private AdminLoginModule adminLoginModule;
Scanner sc=new Scanner(System.in);
    public AdminLoginView()
    {
        adminLoginModule=new AdminLoginModule(this);
    }

    public void loginInit()
    {
        adminLoginModule.addCreditantials();
        System.out.println("------------------------------------------------");
        System.out.println("App Name ----->"+InterviewPanelHomePage.getInstance().getAppName());
        System.out.println("App Version -------->"+InterviewPanelHomePage.getInstance().getAppVersion());
        System.out.println("----------------------------------------------------");
       loginCheckText();
    }

    private void loginCheckText() {
        System.out.println("\n\t\t\t\t   Login.");
        System.out.println("User Name:");
        String userName=sc.next();
        System.out.println("Password:");
        String password=sc.next();
        adminLoginModule.loginCheck(userName,password);
    }

    public void onSuccess()
    {
        System.out.flush();
        System.out.println("\n\nLogin SuccessFull....\n\n Welcome to "+InterviewPanelHomePage.getInstance().getAppName()
        +"-- V "+InterviewPanelHomePage.getInstance().getAppVersion());
        adminLoginModule.redirectPoint();
    }
    public void showAlert(String alert)
    {
        System.out.println(alert);
    }
}
