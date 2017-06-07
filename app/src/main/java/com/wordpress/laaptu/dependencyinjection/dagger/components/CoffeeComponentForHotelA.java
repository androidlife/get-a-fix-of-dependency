package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.dagger.HotelAScope;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.hotels.Hotel;
import com.wordpress.laaptu.dependencyinjection.hotels.HotelA;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeHeart;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeLove;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by laaptu on 6/7/17.
 */
@Subcomponent(modules = {CoffeeBrewerProvider.class})
@HotelAScope
public interface CoffeeComponentForHotelA {
    void provideCoffeeBrewer(CafeLove cafeLove);

    void provideCoffeeBrewer(CafeHeart cafeHeart);
}
