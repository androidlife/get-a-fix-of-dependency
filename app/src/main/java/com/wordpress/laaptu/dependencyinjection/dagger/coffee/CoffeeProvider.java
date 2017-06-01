package com.wordpress.laaptu.dependencyinjection.dagger.coffee;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 4/28/17.
 */
@Module
public class CoffeeProvider {

    @Provides
    CoffeeHelper getCoffeeHelper() {
        return new CoffeeHelper();
    }

    @Provides
    Coffee.Flavor getFlavor() {
        return Coffee.Flavor.Espresso;
    }
}
