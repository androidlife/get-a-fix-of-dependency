package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.WaterProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by laaptu on 6/7/17.
 */
@Component(modules = {WaterProvider.class})
@Singleton
public interface WaterComponent {
    CoffeeComponentForHotelA getCoffeeComponentForHotelA(CoffeeBrewerProvider coffeeBrewerProvider);
    CoffeeComponentForHotelB getCoffeeComponentForHotelB(CoffeeBrewerProvider coffeeBrewerProvider);
}
