package com.wordpress.laaptu.dependencyinjection.hotels.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wordpress.laaptu.dependencyinjection.utils.Cafe;

/**
 */

public class CafeLove extends Restaurant {

    public CafeLove() {

    }

    public static CafeLove getInstance() {
        CafeLove cafeLove = new CafeLove();
        cafeLove.setArguments(Restaurant.buildParams(Cafe.CAFE_LOVE));
        return cafeLove;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



}
