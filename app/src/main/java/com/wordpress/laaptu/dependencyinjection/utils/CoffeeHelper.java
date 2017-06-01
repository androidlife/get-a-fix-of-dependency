package com.wordpress.laaptu.dependencyinjection.utils;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;

import javax.inject.Inject;

/**
 * Created by laaptu on 4/28/17.
 */

public class CoffeeHelper {

    public CoffeeHelper() {

    }

    public CoffeeBrewer getCoffeeBrewer(int waterQuantity, Coffee.Flavor flavor) {
        Water water = new Water(waterQuantity);
        Coffee coffee = new Coffee(flavor);
        return new CoffeeBrewer(water, coffee);
    }

    //---------------
    private int waterQuantity;
    private Coffee.Flavor flavor;

    public CoffeeHelper(int waterQuantity, Coffee.Flavor flavor) {
        this.waterQuantity = waterQuantity;
        this.flavor = flavor;
    }


    public CoffeeBrewer getCoffeeBrewer() {
        Water water = new Water(waterQuantity);
        Coffee coffee = new Coffee(flavor);
        return new CoffeeBrewer(water, coffee);
    }




}
