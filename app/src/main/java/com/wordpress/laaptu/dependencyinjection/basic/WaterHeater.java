package com.wordpress.laaptu.dependencyinjection.basic;

/**
 * Created by laaptu on 4/25/17.
 */

public class WaterHeater {
    private Water water;

    public WaterHeater(Water water) {
        this.water = water;
    }

    public void on() {
        water.heat();
    }

    public void off() {

    }
}
