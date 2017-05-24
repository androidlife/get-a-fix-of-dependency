package com.wordpress.laaptu.dependencyinjection.dagger.restaurantb.providers;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/24/17.
 */
@Module
public class CoffeeProvider {
    @Provides
    public CoffeeHelper getCoffeeHelper(Coffee.Flavor flavor) {
        return new CoffeeHelper(20, flavor);
    }
}
