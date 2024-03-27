package com.interviewpanel.adminlogin;

import java.util.List;

import com.interviewpanel.adminprofile.AdminProfileView;
import com.interviewpanel.db.InterviewPanelDatabase;
import com.interviewpanel.homepanel.HomeView;
import com.interviewpanel.models.Creditantials;
import com.interviewpanel.models.SessionStore;

public class AdminLoginModule {

    private AdminLoginView adminLoginView;
    private List<Creditantials> creditantialsList;
    private SessionStore sessionStore;

    public AdminLoginModule(AdminLoginView adminLoginView) {
        this.adminLoginView = adminLoginView;
        sessionStore = SessionStore.getInstance();
    }

    public void loginCheck(String userName, String password) {
        int loginUserId=0;
        String role="";
        creditantialsList = InterviewPanelDatabase.getInstance().getCreditantialsList();
        if (isValidUserName(creditantialsList, userName)) {
            if (isValidPassword(creditantialsList, userName, password)) {
                for(Creditantials credit:creditantialsList) {

                    if (credit.getUserName().equals(userName) && credit.getPassword().equals(password) )
                    {
                        loginUserId=credit.getEmpId();
                        role=credit.getType();
                    }
                }
                sessionStoreGet(loginUserId,userName,password,role);
                adminLoginView.onSuccess();
            } else {
                adminLoginView.showAlert("Invalid Password");
                adminLoginView.loginCheckText();
            }
        } else {
            adminLoginView.showAlert("Invalid Username");
            adminLoginView.loginCheckText();
        }
    }
    public void sessionStoreGet(int loginUserId, String userName, String password, String role) {
        sessionStore.setUserId(loginUserId);
        sessionStore.setPassword(password);
        sessionStore.setRole(role);
        sessionStore.setUserName(userName);

    }

    private boolean isValidPassword(List<Creditantials> creditantialsList2, String userName, String password) {
        for (Creditantials credit : creditantialsList2) {
            if (credit.getUserName().equals(userName) && credit.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidUserName(List<Creditantials> creditantialsList2, String userName) {
        for (Creditantials creditantials : creditantialsList2) {
            if (creditantials.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void addCreditantials() {
        Creditantials creditantials = new Creditantials(0,"zsgs", "admin", "Admin",0);
        InterviewPanelDatabase.getInstance().addCreditantials(creditantials);
        InterviewPanelDatabase.getInstance().loadDataFromJsonFiles();
    }

    public void redirectPoint() {
        creditantialsList = InterviewPanelDatabase.getInstance().getCreditantialsList();
        // new ManageCustomerView().customerInit();
        if (!creditantialsList.isEmpty()) {
            new HomeView().homeInit();
        } else {
            AdminProfileView adminProfileView = new AdminProfileView();
            adminProfileView.adminProfileinit();
        }
    }
}
