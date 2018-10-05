package com.example.saransh1337.droidappcoldstarttime;

import android.util.Log;

public class Logging_ColdStart {


    public Logging_ColdStart() {

    }

    public static void verbose(String logStr) {
        Log.v(ConfigColdStartTest.coldStartTag, logStr);
    }

    public static void trace(String logStr) {
        Log.d(ConfigColdStartTest.coldStartTag, logStr);
    }

    public static void debug(String logStr) {
        Log.d(ConfigColdStartTest.coldStartTag, logStr);
    }

    public static void info(String logStr) {
        Log.i(ConfigColdStartTest.coldStartTag, logStr);
    }

    public static void warn(String logStr) {
        Log.w(ConfigColdStartTest.coldStartTag, logStr);
    }

    public static void error(String logStr) {
        Log.e(ConfigColdStartTest.coldStartTag, logStr);
    }


}
