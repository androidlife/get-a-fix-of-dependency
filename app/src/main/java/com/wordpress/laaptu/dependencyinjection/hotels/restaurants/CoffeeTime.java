package com.wordpress.laaptu.dependencyinjection.hotels.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wordpress.laaptu.dependencyinjection.hotels.HotelB;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.utils.Cafe;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;

/**
 */

public class CoffeeTime extends Restaurant {

    public CoffeeTime() {

    }

    public static CoffeeTime getInstance() {
        CoffeeTime coffeeTime = new CoffeeTime();
        coffeeTime.setArguments(Restaurant.buildParams(Cafe.COFFEE_TIME));
        return coffeeTime;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getContext() instanceof HotelB) {
            ((HotelB) getContext()).coffeeComponentForHotelB.provideCoffeeBrewer(this);
        }
    }

    @Inject
    @Named("ForHotelB")
    public CoffeeBrewer coffeeBrewer;

    @Override
    public void onButtonClick() {
        super.onButtonClick();
        coffeeBrewer.brewCoffee();
    }


}
