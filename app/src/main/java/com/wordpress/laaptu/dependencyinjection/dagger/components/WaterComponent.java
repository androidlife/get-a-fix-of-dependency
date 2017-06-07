package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.WaterProvider;

import dagger.Component;

/**
 * Created by laaptu on 5/24/17.
 */
@Component(modules = {WaterProvider.class})
public interface WaterComponent {
    CoffeeComponent getCoffeeComponent(CoffeeBrewerProvider coffeeBrewerProvider);
}
