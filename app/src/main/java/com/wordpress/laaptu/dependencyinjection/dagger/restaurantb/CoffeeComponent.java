package com.wordpress.laaptu.dependencyinjection.dagger.restaurantb;

import com.wordpress.laaptu.dependencyinjection.dagger.restaurantb.providers.CoffeeProvider;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;

import dagger.Subcomponent;

/**
 * Created by laaptu on 5/24/17.
 */
@Subcomponent(modules = {CoffeeProvider.class})
public interface CoffeeComponent {
    void provideCoffee(RestaurantB restaurantB);
}
