package com.interviewpanel.adminprofile;

import java.util.List;

import com.interviewpanel.adminlogin.AdminLoginView;
import com.interviewpanel.db.InterviewPanelDatabase;
import com.interviewpanel.models.Admin;
import com.interviewpanel.models.Creditantials;

public class AdminProfileModule {


    private AdminProfileView adminProfileView;

    public AdminProfileModule(AdminProfileView adminProfileView)
    {
        this.adminProfileView=adminProfileView;
    }
public void addProfileCreditantials(String name,String phoneNo,String  email,String address, String  userName, String password,String role)
{
   InterviewPanelDatabase database = InterviewPanelDatabase.getInstance();
    int lastCredentialsId = database.creditantialsList().stream().mapToInt(Creditantials::getId).max().orElse(0);
    int  creditUserID= lastCredentialsId + 1;
    int lastAdminId = database.adminList().stream().mapToInt(Admin::getId).max().orElse(0);
    int  AdminUserID= lastAdminId + 1;
    Admin admin =new Admin(AdminUserID,name, phoneNo, email, address);
    Creditantials creditantials=new Creditantials(creditUserID,userName, password,role,AdminUserID);
    InterviewPanelDatabase.getInstance().addAdminProfile(admin);
    InterviewPanelDatabase.getInstance().addCreditantials(creditantials);
    InterviewPanelDatabase.getInstance().removeCreditantials(0);
    InterviewPanelDatabase.getInstance().adminListExport();
    InterviewPanelDatabase.getInstance().creditantialsListExport();
new AdminLoginView().loginInit();

}


public void showAdminDetails() {
    List<Admin> adminList=InterviewPanelDatabase.getInstance().adminList();
    adminProfileView.showMessage(Admin.getAdminTitle());
    for(Admin admin:adminList)
    {
        adminProfileView.showMessage(admin.toString());
    }
    List<Creditantials> creditantialsList=InterviewPanelDatabase.getInstance().creditantialsList();
    for(Creditantials credit:creditantialsList)
    {
        adminProfileView.showMessage(credit.toString());
    }
}
}
