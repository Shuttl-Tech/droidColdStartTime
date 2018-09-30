package com.example.saransh1337.droidappcoldstarttime;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;

public class Utils_ColdStart {

    public void launchApp(String packageName) {

        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent launchIntent;
        launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        launchIntent.addFlags('耀');
        context.startActivity(launchIntent);
    }
}
