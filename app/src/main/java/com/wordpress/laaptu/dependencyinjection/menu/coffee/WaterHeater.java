package com.wordpress.laaptu.dependencyinjection.menu.coffee;

import timber.log.Timber;

/**
 * Created by laaptu on 4/25/17.
 */

public class WaterHeater {
    private Water water;

    public WaterHeater(Water water) {
        this.water = water;
    }

    public void on() {
        Timber.d("Heater is on. Water is boiling");
        water.heat();
    }

    public void off() {
        Timber.d("Heater if off. Water is boiled");
    }
}
