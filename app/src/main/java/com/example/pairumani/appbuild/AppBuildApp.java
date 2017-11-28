package com.example.pairumani.appbuild;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Pairumani on 31-10-2017.
 */

public class AppBuildApp extends Application{

     @Override
    public void onCreate(){

         super.onCreate();

         FacebookSdk.sdkInitialize(getApplicationContext());
         AppEventsLogger.activateApp(this);
     }
}
