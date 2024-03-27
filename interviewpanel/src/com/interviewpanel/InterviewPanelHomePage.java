package com.interviewpanel;

import com.interviewpanel.adminlogin.AdminLoginView;

public class InterviewPanelHomePage {
private static InterviewPanelHomePage interviewPanelHomePage;

private String appName="Interview Panel";
private String appVersion="0.01";

public static InterviewPanelHomePage getInstance()
{
    if(interviewPanelHomePage==null)
    {
        interviewPanelHomePage=new InterviewPanelHomePage();
    }
    return interviewPanelHomePage;
}


public void create()
{
    new AdminLoginView().loginInit();
}


public String getAppName() {
    return appName;
}


public String getAppVersion() {
    return appVersion;
}


public static void main(String[] args) {
    InterviewPanelHomePage.getInstance().create();
}


}
