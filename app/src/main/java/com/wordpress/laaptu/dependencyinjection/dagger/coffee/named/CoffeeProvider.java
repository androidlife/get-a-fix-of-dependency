package com.wordpress.laaptu.dependencyinjection.dagger.coffee.named;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/1/17.
 */
@Module
public class CoffeeProvider {
    @Provides @Named("Small")
    public int smallQuantity() {
        return 10;
    }
    @Provides @Named("Medium")
    public int mediumQuantity(){
        return 20;
    }
    @Provides @Named("Large")
    public int largeQuantity(){
        return 30;
    }

    @Provides
    public Coffee.Flavor getFlavor() {
        return Coffee.Flavor.Americano;
    }
    @Provides
    public CoffeeHelper getCoffeeHelper() {
        return new CoffeeHelper();
    }
}
