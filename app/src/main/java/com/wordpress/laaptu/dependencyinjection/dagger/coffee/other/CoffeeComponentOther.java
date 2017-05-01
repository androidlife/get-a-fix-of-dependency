package com.wordpress.laaptu.dependencyinjection.dagger.coffee.other;

import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import dagger.Component;

/**
 * Created by laaptu on 5/1/17.
 */

@Component(modules = {CoffeeProviderOther.class})
public interface CoffeeComponentOther {
    void provideCoffee(RestaurantB restaurantB);
}
