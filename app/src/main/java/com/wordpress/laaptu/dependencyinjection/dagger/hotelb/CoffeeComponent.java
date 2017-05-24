package com.wordpress.laaptu.dependencyinjection.dagger.hotelb;

import com.wordpress.laaptu.dependencyinjection.HotelB;
import com.wordpress.laaptu.dependencyinjection.dagger.hotelb.providers.CoffeeProvider;

import dagger.Component;

/**
 * Created by laaptu on 5/24/17.
 */
@Component(modules = {CoffeeProvider.class},dependencies = {IngredientsComponent.class})
public interface CoffeeComponent {
    void provideCoffee(HotelB hotelB);
}
