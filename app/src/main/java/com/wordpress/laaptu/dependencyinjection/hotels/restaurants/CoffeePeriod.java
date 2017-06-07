package com.wordpress.laaptu.dependencyinjection.hotels.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wordpress.laaptu.dependencyinjection.utils.Cafe;

import timber.log.Timber;

/**
 */

public class CoffeePeriod extends Restaurant {

    public CoffeePeriod() {

    }

    public static CoffeePeriod getInstance() {
        CoffeePeriod coffeePeriod = new CoffeePeriod();
        coffeePeriod.setArguments(Restaurant.buildParams(Cafe.COFFEE_PERIOD));
        return coffeePeriod;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.d("onActivityCreated()");
    }


}
