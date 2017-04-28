package com.wordpress.laaptu.dependencyinjection.basic;

import timber.log.Timber;

/**
 * Created by laaptu on 4/25/17.
 */

public class CoffeeMaker {
    private int waterQuantity, sugarQuantity, coffeeQuantity;

    public CoffeeMaker(int... quantities) {
        waterQuantity = quantities[0];
        sugarQuantity = quantities[1];
        coffeeQuantity = quantities[2];

    }

    public void brewCoffee(Coffee.Flavor flavor) {
        Water water = new Water(waterQuantity);
        Mixture mixture = new Mixture(water, sugarQuantity, coffeeQuantity);
        Coffee coffee = mixture.getCoffee(flavor);
        Timber.d("*************** Coffee ready to serve ****************************");
    }
}
