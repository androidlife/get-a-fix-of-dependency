package com.wordpress.laaptu.dependencyinjection.dagger;

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
}
