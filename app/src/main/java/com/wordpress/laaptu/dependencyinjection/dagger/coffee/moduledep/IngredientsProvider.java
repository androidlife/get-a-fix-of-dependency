package com.wordpress.laaptu.dependencyinjection.dagger.coffee.moduledep;

import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;

import dagger.Module;
import dagger.Provides;

/**
 * Created by laaptu on 6/1/17.
 */
@Module
public class IngredientsProvider {
    @Provides
    public int quantities() {
        return 10;
    }

    @Provides
    public Coffee.Flavor getFlavor() {
        return Coffee.Flavor.Latte;
    }
}
