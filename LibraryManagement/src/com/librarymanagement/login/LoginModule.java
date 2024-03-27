package com.librarymanagement.login;

import java.util.List;

import com.librarymanagement.adminprofile.AdminProfileView;
import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.home.HomeView;
import com.librarymanagement.models.Creditantials;
import com.librarymanagement.models.SessionStore;

class LoginModule {

private LoginView lv;

private List<Creditantials> creditantialsList;
private SessionStore sessionStore;
    LoginModule(LoginView loginView)
    {
        lv=loginView;
        sessionStore = SessionStore.getInstance();
    }

        public void validateUser(String userName,String password)
        {
            int loginUserId=0;
            String role="";
            int libraryId=0;
            creditantialsList=LibraryDatabase.getInstance().creditantialsList();

            if(isValidUserName(creditantialsList,userName))
            {
                if(isValidPassword(creditantialsList,userName,password))
                {
                    for(Creditantials credit:creditantialsList) {

                        if (credit.getUserName().equals(userName) && credit.getPassword().equals(password) )
                        {
                            loginUserId=credit.getUserId();
                            role=credit.getrole();
                            libraryId=credit.getLibraryId();
                        }
                    }
                        sessionStoreGet(loginUserId,userName,password,role,libraryId);
                        lv.onSuccess();
                }
                else
                {
                    lv.showAlert("Invaild Password");
                    lv.login();
                }
            }
            else
            {
                lv.showAlert("Invaild Username");
                lv.login();
            }
        }

    public void sessionStoreGet(int loginUserId, String userName, String password, String role,int libraryid) {
        sessionStore.setUserId(loginUserId);
        sessionStore.setPassword(password);
        sessionStore.setRole(role);
        sessionStore.setUserName(userName);
        sessionStore.setLibraryId(libraryid);

    }


    public void redirectPoint()
{
    creditantialsList=LibraryDatabase.getInstance().creditantialsList();
    // new ManageCustomerView().customerInit();
    if(!creditantialsList.isEmpty())
    {
        new HomeView().homeInit();
    }
    else
    {
        AdminProfileView adminProfileView=new AdminProfileView();
        adminProfileView.adminProfileinit();
    }
}


        public void librarySetup()
        {

        }
        private boolean isValidUserName(List<Creditantials> creditantialsList,String userName)
        {
            for(Creditantials credit:creditantialsList)
            {
                if (credit.getUserName().equals(userName)) {
                    return true;
                }
            }
            return false;

        }
        private boolean isValidPassword(List<Creditantials> creditantialsList,String userName,String password)
        {

            for(Creditantials credit:creditantialsList)
            {

                if (credit.getUserName().equals(userName) && credit.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }

        public void addCreditantials() {
/*            Creditantials creditantials=new Creditantials( "zsgs", "admin","Admin",0);
            LibraryDatabase.getInstance().addCreditantials(creditantials);*/
            LibraryDatabase.getInstance().loadDataFromJsonFiles();
        }
}
