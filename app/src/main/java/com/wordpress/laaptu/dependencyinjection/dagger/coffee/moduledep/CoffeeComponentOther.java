package com.wordpress.laaptu.dependencyinjection.dagger.coffee.moduledep;

import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;

import dagger.Component;

/**
 * Created by laaptu on 5/1/17.
 */

@Component(modules = {CoffeeProviderOther.class,IngredientsProvider.class})
public interface CoffeeComponentOther {
    void provideCoffee(RestaurantB restaurantB);
}
