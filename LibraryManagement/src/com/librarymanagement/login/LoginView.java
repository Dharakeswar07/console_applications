package com.librarymanagement.login;

import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;

public class LoginView {
private     LoginModule loginModule ;
Scanner sc=new Scanner(System.in);

public LoginView()
{
    loginModule=new LoginModule(this);
}
    public void init()
    {

       loginModule.addCreditantials();
       LibraryManagement2024.getInstance().clear();
       System.out.println("\t\t\t\t\t\t\t Library Management");
        System.out.println("------------------------------------------------");
        System.out.println("App Name ----->"+LibraryManagement2024.getInstance().getAppName());
        System.out.println("App Version -------->"+LibraryManagement2024.getInstance().getAppVersion());
        System.out.println("----------------------------------------------------");
        login();
           }

           public void login()
           {
               System.out.println("\t\t\t\t\t\t\t  Login");
               System.out.println("User Name:");
               String userName=sc.next();
               System.out.println("\nPassword:");
               String password=sc.next();

               loginModule.validateUser(userName, password);

           }

    public void onSuccess()
    {
        LibraryManagement2024.getInstance().clear();
        loginModule.redirectPoint();
    }
    public void showAlert(String alertText)
    {
        System.out.println(alertText);
    }
}
