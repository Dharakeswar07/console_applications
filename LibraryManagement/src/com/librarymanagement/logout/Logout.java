package com.librarymanagement.logout;

import com.librarymanagement.login.LoginView;
import com.librarymanagement.models.SessionStore;

public class Logout {

    private static Logout logout;
    private SessionStore sessionStore;
    private  LoginView loginView;
    public  static Logout getInstance()
    {
        if(logout==null)
        {
            logout=new Logout();
        }
        return logout;
    }

    public void logout() {
        // Clear the session when user logs out
        sessionStore = null;
       new LoginView().init();
    }

}
