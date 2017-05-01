package com.wordpress.laaptu.dependencyinjection.dagger.coffee.constructor;

import com.wordpress.laaptu.dependencyinjection.HotelB;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import dagger.Component;

/**
 * Created by laaptu on 5/1/17.
 */
@Component(modules = {CoffeeProviderConstructor.class})
public interface CoffeeComp {
    void injectCoffeeHelper(HotelB hotelB);
}
