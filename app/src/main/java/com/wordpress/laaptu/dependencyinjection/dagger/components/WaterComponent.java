package com.wordpress.laaptu.dependencyinjection.dagger.components;

import com.wordpress.laaptu.dependencyinjection.dagger.HotelAScope;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.WaterProvider;
import com.wordpress.laaptu.dependencyinjection.hotels.HotelA;

import dagger.Component;

/**
 * Created by laaptu on 6/7/17.
 */
@Component(modules = {WaterProvider.class})
@HotelAScope
public interface WaterComponent {
    void provideWater(HotelA hotelA);
}
