package com.wordpress.laaptu.dependencyinjection.dagger.providers;

import com.wordpress.laaptu.dependencyinjection.dagger.HotelAScope;
import com.wordpress.laaptu.dependencyinjection.dagger.HotelBScope;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/24/17.
 */
@Module
public class CoffeeBrewerProvider {

    private Coffee.Flavor flavor;
    public CoffeeBrewerProvider(Coffee.Flavor flavor) {
        this.flavor = flavor;
    }

    @Provides
    public Coffee getCoffee() {
        return new Coffee(flavor);
    }

    @Provides
    @Named("ForHotelA")
    @HotelAScope
    public CoffeeBrewer provideCoffeeBrewerForHotelA(Water water, Coffee coffee) {
        return new CoffeeBrewer(water, coffee);
    }

    @Provides
    @Named("ForHotelB")
    @HotelBScope
    public CoffeeBrewer provideCoffeeBrewerForHotelB(Water water, Coffee coffee) {
        return new CoffeeBrewer(water, coffee);
    }
}
