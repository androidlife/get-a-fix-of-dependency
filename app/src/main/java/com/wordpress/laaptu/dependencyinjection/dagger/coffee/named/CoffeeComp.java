package com.wordpress.laaptu.dependencyinjection.dagger.coffee.named;

import com.wordpress.laaptu.dependencyinjection.HotelB;

import dagger.Component;

/**
 * Created by laaptu on 5/1/17.
 */
@Component(modules = {CoffeeProvider.class})
public interface CoffeeComp {
    void injectCoffeeHelper(HotelB hotelB);
}
