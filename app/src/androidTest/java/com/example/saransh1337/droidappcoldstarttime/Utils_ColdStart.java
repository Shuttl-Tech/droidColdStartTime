package com.example.saransh1337.droidappcoldstarttime;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;

public class Utils_ColdStart {

    //public static UiDevice _mDevice = .mDevice;

    /**
     * @return true if app is launched and is in FG; false otherwise
     */
    public void launchApp() {


        String appPkgName = ConfigColdStartTest.PACKAGENAME_CONSUMER;
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent launchIntent;
        launchIntent = context.getPackageManager().getLaunchIntentForPackage(appPkgName);

        context.startActivity(launchIntent);

    }
}
