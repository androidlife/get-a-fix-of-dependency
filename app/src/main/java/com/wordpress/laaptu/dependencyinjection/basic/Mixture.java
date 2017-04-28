package com.wordpress.laaptu.dependencyinjection.basic;

import timber.log.Timber;

/**
 * Created by laaptu on 4/25/17.
 */

public class Mixture {
    private Water water;
    private int sugarQuantity, coffeeQuantity;

    public Mixture(Water water, int sugarQuantity, int coffeeQuantity) {
        this.water = water;
        this.sugarQuantity = sugarQuantity;
        this.coffeeQuantity = coffeeQuantity;
    }

    public Coffee getCoffee(Coffee.Flavor flavor) {
        WaterHeater waterHeater = new WaterHeater(water);
        Timber.d("Boiling water");
        waterHeater.on();
        waterHeater.off();
        Timber.d("Water boiled");
        Timber.d("Mixing %d gram of sugar and %d gram of coffee into hot water",
                sugarQuantity, coffeeQuantity);
        return new Coffee(flavor);
    }
}
