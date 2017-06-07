package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeLove;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeHeart;

import dagger.Subcomponent;

/**
 * Created by laaptu on 4/28/17.
 */

@Subcomponent(modules = {CoffeeBrewerProvider.class})
public interface CoffeeComponent {
    void provideCoffeeBrewer(CafeLove cafeLove);
    void provideCoffeeBrewer(CafeHeart cafeHeart);
}
