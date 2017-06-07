package com.wordpress.laaptu.dependencyinjection.dagger.providers;

import com.wordpress.laaptu.dependencyinjection.dagger.HotelAScope;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 6/7/17.
 */
@Module
public class WaterProvider {
    private int waterQuantity;
    public WaterProvider(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    @Provides
    @Singleton
    public Water getWater() {
        return new Water(waterQuantity);
    }

}
