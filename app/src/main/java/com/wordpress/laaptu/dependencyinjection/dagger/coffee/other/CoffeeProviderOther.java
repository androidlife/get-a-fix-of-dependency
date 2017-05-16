package com.wordpress.laaptu.dependencyinjection.dagger.coffee.other;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 5/1/17.
 */

@Module
public class CoffeeProviderOther {

    @Provides
    public int quantities() {
        return 10;
    }

    //if this provide is included, it will throw compile error as
    //dagger is not clear which quantity to use
//    @Provides int values(){
//        return 20;
//    }

    @Provides
    public Coffee.Flavor getFlavor() {
        return Coffee.Flavor.Latte;
    }

    @Provides
    public CoffeeHelper coffeeHelper(int quantity, Coffee.Flavor flavor) {
        return new CoffeeHelper(quantity, flavor);
    }

//    @Provides
//    public CoffeeHelper coffeeHelper() {
//        return new CoffeeHelper(10, Coffee.Flavor.Espresso);
//    }


}
