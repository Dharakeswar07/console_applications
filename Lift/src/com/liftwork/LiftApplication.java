package com.liftwork;

import com.liftwork.lift.LiftView;

public class LiftApplication {
    private static LiftApplication liftApplication;

    private String appName="Lift Operation";
    private String appVersion="0.01";

    public static LiftApplication getInstance()
    {
        if(liftApplication==null)
        {
            liftApplication=new LiftApplication();
        }
        return liftApplication;
    }
public void create()
{
    new LiftView().init();
}

    public String getAppName() {
        return appName;
    }


    public String getAppVersion() {
        return appVersion;
    }


    public static void main(String[] args) {
        LiftApplication.getInstance().create();
    }

}
