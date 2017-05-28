package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.HotelB;
import com.wordpress.laaptu.dependencyinjection.dagger.CoffeeProvider;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantA;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by laaptu on 4/28/17.
 */

@Subcomponent(modules = {CoffeeBrewerProvider.class})
public interface CoffeeComponent {
    void provideCoffeeBrewer(RestaurantA restaurantA);
    void provideCoffeeBrewer(RestaurantB restaurantB);
}
