#!/usr/bin/env bash

# building tests
./gradlew :app:clean :app:assembleDebugAndroidTest :app:assembleDebug
sleep 5s

### CLEAR LOGCAT ###
adb logcat -c &

### CLEAR OUTPUT FILES
true > output_RAW.txt
true > output_PROCESSED.txt

##
adb push ./app/build/outputs/apk/debug/app-debug.apk /data/local/tmp/com.example.saransh1337.droidappcoldstarttime
adb shell pm install -t -r "/data/local/tmp/com.example.saransh1337.droidappcoldstarttime" pkg: /data/local/tmp/com.example.saransh1337.droidappcoldstarttime

# force stop test apk
adb shell am force-stop com.example.saransh1337.droidappcoldstarttime

# pushing test apk to device
adb push ./app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk /data/local/tmp/com.example.saransh1337.droidappcoldstarttime.test
adb shell pm install -t -r "/data/local/tmp/com.example.saransh1337.droidappcoldstarttime.test" pkg: /data/local/tmp/com.example.saransh1337.droidappcoldstarttime.test

# install test apk
adb shell pm install -t -r "/data/local/tmp/com.example.saransh1337.droidappcoldstarttime.test"

# run test
adb shell am instrument -w -r   -e debug false -e class com.example.saransh1337.droidappcoldstarttime.DroidColdStartTest com.example.saransh1337.droidappcoldstarttime.test/android.support.test.runner.AndroidJUnitRunner

sleep 10s
adb logcat -d | grep --line-buffered 'Displayed app.goplus.in.myapplication' > output_RAW.txt

sh ./_processOutput.sh




