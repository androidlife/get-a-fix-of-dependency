package com.wordpress.laaptu.dependencyinjection;

import android.app.Application;

import com.wordpress.laaptu.dependencyinjection.dagger.components.DaggerWaterComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.components.WaterComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.WaterProvider;

import timber.log.Timber;

/**
 */

public class MainApplication extends Application {


    private WaterComponent waterComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        waterComponent = DaggerWaterComponent.builder().waterProvider(new WaterProvider(20)).build();
    }

    public WaterComponent getWaterComponent() {
        return waterComponent;
    }





}
