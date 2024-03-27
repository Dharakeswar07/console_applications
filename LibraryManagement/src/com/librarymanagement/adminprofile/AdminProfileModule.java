package com.librarymanagement.adminprofile;

import java.util.List;

import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.login.LoginView;
import com.librarymanagement.models.Admin;
import com.librarymanagement.models.Creditantials;

public class AdminProfileModule {


    private AdminProfileView adminProfileView;
    private Creditantials creditantials;
    // private Admin admin;
    private LoginView loginView = new LoginView();

    AdminProfileModule(AdminProfileView adminProfileView)
    {
        this.adminProfileView=adminProfileView;
    }


public void addProfileCreditantials(String name,String phoneNo,String email,String address,String userName,String password,String role)
{
    LibraryDatabase database = LibraryDatabase.getInstance();
    int lastId = database.adminList().stream().mapToInt(Admin::getId).max().orElse(0);
    int adminId = lastId + 1;

    Admin admin =new Admin(adminId,name, phoneNo, email, address);

    int lastCredentialsId = database.creditantialsList().stream().mapToInt(Creditantials::getUserId).max().orElse(0);
    int  creditUserID= lastCredentialsId + 1;
    Creditantials creditantials=new Creditantials( creditUserID,userName, password,role,0);

    LibraryDatabase.getInstance().addAdminProfile(admin);
    LibraryDatabase.getInstance().addCreditantials(creditantials);
    LibraryDatabase.getInstance().removeCreditantials(0);
    LibraryDatabase.getInstance().exportAdminList();
    LibraryDatabase.getInstance().exportCreditantialsList();
    loginView.init();

}


public void showAdminDetails() {
    List<Admin> adminList=LibraryDatabase.getInstance().adminList();
    adminProfileView.showMessage(Admin.getAdminTitle());
    for(Admin admin:adminList)
    {
        System.out.println(admin);
    }
    List<Creditantials> creditantialsList=LibraryDatabase.getInstance().creditantialsList();
    for(Creditantials credit:creditantialsList)
    {
        System.out.println(credit);
    }
}

}




