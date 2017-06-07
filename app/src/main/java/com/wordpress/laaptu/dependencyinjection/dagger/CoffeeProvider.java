package com.wordpress.laaptu.dependencyinjection.dagger;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 4/28/17.
 */
@Module
public class CoffeeProvider {

    @CustomScope
    @Provides
    CoffeeHelper getCoffeeHelper() {
        return new CoffeeHelper();
    }

}
