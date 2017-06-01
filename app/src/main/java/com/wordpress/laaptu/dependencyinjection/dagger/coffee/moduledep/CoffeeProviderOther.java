package com.wordpress.laaptu.dependencyinjection.dagger.coffee.moduledep;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/1/17.
 */

@Module
public class CoffeeProviderOther {
    @Provides
    public CoffeeHelper coffeeHelper(int quantity, Coffee.Flavor flavor) {
        return new CoffeeHelper(quantity, flavor);
    }

}
