package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.dagger.HotelBScope;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.hotels.HotelB;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeLove;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CoffeePeriod;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CoffeeTime;

import dagger.Subcomponent;

/**
 * Created by laaptu on 6/7/17.
 */
@Subcomponent(modules = {CoffeeBrewerProvider.class})
@HotelBScope
public interface CoffeeComponentForHotelB {
    void provideCoffeeBrewer(CoffeeTime coffeeTime);
    void provideCoffeeBrewer(CoffeePeriod coffeePeriod);
}
