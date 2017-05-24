package com.wordpress.laaptu.dependencyinjection.dagger.hotelb.providers;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/24/17.
 */
@Module
public class IngredientsProvider {
    @Provides
    public Coffee.Flavor getFlavor() {
        return Coffee.Flavor.Americano;
    }

    @Provides
    public Water getWater() {
        return new Water(20);
    }
}
