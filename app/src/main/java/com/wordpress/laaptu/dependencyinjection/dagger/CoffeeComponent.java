package com.wordpress.laaptu.dependencyinjection.dagger;

import com.wordpress.laaptu.dependencyinjection.HotelB;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantA;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;

import dagger.Component;

/**
 * Created by laaptu on 4/28/17.
 */
@Component(modules = {CoffeeProvider.class})
public interface CoffeeComponent {
    void provideCoffee(RestaurantA restaurantA);

    void provideCoffee(RestaurantB restaurantB);

    void provideCoffee(HotelB hotelB);
}
