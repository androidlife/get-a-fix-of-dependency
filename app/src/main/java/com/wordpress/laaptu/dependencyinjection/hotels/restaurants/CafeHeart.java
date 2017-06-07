package com.wordpress.laaptu.dependencyinjection.hotels.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.hotels.HotelA;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.utils.Cafe;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;

/**
 */

public class CafeHeart extends Restaurant {

    public CafeHeart() {

    }

    public static CafeHeart getInstance() {
        CafeHeart cafeHeart = new CafeHeart();
        cafeHeart.setArguments(Restaurant.buildParams(Cafe.CAFE_HEART));
        return cafeHeart;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getContext() instanceof HotelA) {
            ((HotelA) getContext()).coffeeComponentForHotelA.provideCoffeeBrewer(this);
        }
    }

    @Inject
    @Named("ForHotelA")
    public CoffeeBrewer coffeeBrewer;

    @Override
    public void onButtonClick() {
        super.onButtonClick();
        coffeeBrewer.brewCoffee();
    }


}
