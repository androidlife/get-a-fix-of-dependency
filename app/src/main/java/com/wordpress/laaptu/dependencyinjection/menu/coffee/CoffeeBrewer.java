package com.wordpress.laaptu.dependencyinjection.menu.coffee;

import timber.log.Timber;

/**
 * Created by laaptu on 4/25/17.
 */

public class CoffeeBrewer {
    private Water water;
    private Coffee coffee;
    private WaterHeater waterHeater;

    public CoffeeBrewer(Water water, Coffee coffee) {
        this.water = water;
        this.coffee = coffee;
        waterHeater = new WaterHeater(this.water);
    }

    public void brewCoffee() {
        waterHeater.on();
        waterHeater.off();
        Timber.d("Brewing %s coffee with %s flavor", water.isWaterHot() ? "Hot" : "Cold",
                coffee.getFlavor());
        Timber.d("----------- Coffee is ready to be served ---------------------");
    }
}
