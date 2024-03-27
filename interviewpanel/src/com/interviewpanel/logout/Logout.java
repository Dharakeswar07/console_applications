package com.interviewpanel.logout;


import com.interviewpanel.adminlogin.AdminLoginView;
import com.interviewpanel.models.SessionStore;

public class Logout {

    private static Logout logout;
    private SessionStore sessionStore;
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
       new AdminLoginView().loginInit();
    }

}
