package com.example.saransh1337.droidappcoldstarttime;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(AndroidJUnit4.class)
public class DroidColdStartTest {

    Utils_ColdStart utils_coldStart = new Utils_ColdStart();
    String appPackageName = ConfigColdStartTest.PACKAGENAME_CONSUMER_DEBUG;
    private UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    @Test
    public void testAppLaunch() {


        int maxRunCount = 5;
        for (int i = 1; i <= maxRunCount; i++) {

            Logging_ColdStart.debug("########### Loop run " + i + " of " + maxRunCount + " START ###########");
            Logging_ColdStart.info("Launching app ");
            utils_coldStart.launchApp(appPackageName);
            Logging_ColdStart.info("Just launched the app. Waiting for 30 seconds");

            coldWait();

            killApp(appPackageName);

            Logging_ColdStart.debug("########### Loop run " + i + " of " + maxRunCount + " DONE ###########");
        }

    }

    public void killApp(String appPackageName) {

        String query = "am force-stop " + appPackageName;

        try {
            Logging_ColdStart.debug("Killing app: " + appPackageName);
            mDevice.executeShellCommand(query);

            Thread.sleep(2000);
        } catch (IOException e) {
            Logging_ColdStart.error("Failed to kill app " + appPackageName);
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void coldWait() {
        try {
            Logging_ColdStart.info("Waiting app to finish loading..");
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            Logging_ColdStart.error("Failed to wait for 30 seconds !");
            e.printStackTrace();
        }
    }


    /**
     * @param queryString
     * @return
     */
    public boolean executeQuery(String queryString) {
        Process mProcess = null;

        try {
            mProcess = Runtime.getRuntime().exec(queryString);
        } catch (IOException var5) {
            Logging_ColdStart.error("Failed to run query '" + queryString + "' !");
            var5.printStackTrace();
        }

        int exitCode;
        try {
            if (mProcess != null) {
                exitCode = mProcess.waitFor();
            } else {
                Logging_ColdStart.error("executeQuery(): mProcess is null");
            }
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

        mProcess.destroy();
        exitCode = mProcess.exitValue();
        if (exitCode == 0) {
            Logging_ColdStart.verbose("Successfully run query '" + queryString + "'");
            return true;
        } else {
            Logging_ColdStart.error("Failed to run query '" + queryString + "'");
            return false;
        }
    }


}
