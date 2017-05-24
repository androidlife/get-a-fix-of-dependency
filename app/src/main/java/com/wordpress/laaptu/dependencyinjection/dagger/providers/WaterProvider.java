package com.wordpress.laaptu.dependencyinjection.dagger.providers;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/24/17.
 */

@Module
public class WaterProvider {
    private int waterQuantity;

    public WaterProvider(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    @Provides
    public Water provideWater() {
        return new Water(waterQuantity);
    }


}
