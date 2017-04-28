package com.wordpress.laaptu.dependencyinjection;

import android.app.Application;

import timber.log.Timber;

/**
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }

}
