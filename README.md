# droidColdStartTime
Measures average app cold start time on emulators varying network speed and latency 


In Android 4.4 (API level 19) and higher, logcat includes an output line containing a value called Displayed. This value represents the amount of time elapsed between launching the process and finishing drawing the corresponding activity on the screen. The elapsed time encompasses the following sequence of events:

* Launch the process.
* Initialize the objects.
* Create and initialize the activity.
* Inflate the layout.
* Draw your application for the first time.
* The reported log line looks similar to the following example:

    ActivityManager: Displayed com.android.myexample/.StartupTiming: +3s534ms
