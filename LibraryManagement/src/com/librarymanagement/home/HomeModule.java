package com.librarymanagement.home;

import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.logout.Logout;
import com.librarymanagement.models.SessionStore;

public class HomeModule {

    private String role;
    private Logout logout;
    private HomeView homeView;
    public HomeModule(HomeView homeView)
    {
        this.homeView=homeView;
    }

    public void startMenuGet() {
        role=SessionStore.getInstance().getRole();
        if(role.equals("Admin"))
        {
            homeView.adminMenu();
        }
        if(role.equals("Employee"))
        {
homeView.employeeMenu();
        }
    }

    public void logout() {
        homeView.showResult("\u001B[31mUser has been Logout...........\u001B[0m");
        Logout.getInstance().logout();
    }

    public void exportData() {
        LibraryDatabase.getInstance().exportAllListJson();
    }
}
