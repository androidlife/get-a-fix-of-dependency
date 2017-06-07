package com.wordpress.laaptu.dependencyinjection.hotels.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wordpress.laaptu.dependencyinjection.utils.Cafe;

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
        Timber.d("onActivityCreated()");
    }


}
