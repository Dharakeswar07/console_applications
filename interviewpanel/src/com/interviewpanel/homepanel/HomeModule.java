package com.interviewpanel.homepanel;

import com.interviewpanel.logout.Logout;
import com.interviewpanel.models.SessionStore;

public class HomeModule {

    private HomeView homeView;
    private SessionStore sessionStore;
    public HomeModule(HomeView homeView)
    {
        this.homeView=homeView;
        sessionStore=SessionStore.getInstance();
    }

    public void homeMenu() {
        if(sessionStore.getRole().equals("Admin"))
        {
            homeView.adminMenu();
        }
        else
        {
            homeView.employeeMenu();
        }
    }

    public void logout() {
        homeView.showMessage("\u001B[31mUser has been Logout...........\u001B[0m");
        new Logout().logout();
    }
    }
