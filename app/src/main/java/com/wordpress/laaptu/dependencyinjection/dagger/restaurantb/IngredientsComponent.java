package com.wordpress.laaptu.dependencyinjection.dagger.restaurantb;

import com.wordpress.laaptu.dependencyinjection.dagger.hotelb.providers.IngredientsProvider;
import com.wordpress.laaptu.dependencyinjection.dagger.restaurantb.providers.CoffeeProvider;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;

import dagger.Component;

/**
 * Created by laaptu on 5/24/17.
 */
@Component(modules = {IngredientsProvider.class})
public interface IngredientsComponent {
    CoffeeComponent provideCoffeeComponent();
}
