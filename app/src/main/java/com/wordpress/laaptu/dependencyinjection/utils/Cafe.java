package com.wordpress.laaptu.dependencyinjection.utils;

import android.graphics.Color;

/**
 * Created by laaptu on 6/7/17.
 */

public enum Cafe {
    CAFE_LOVE("Cafe Love","Espresso",Color.parseColor("#448aff")),
    CAFE_HEART("Cafe Heart","Espresso",Color.parseColor("#8e24aa")),
    COFFEE_TIME("Coffee Time","Americano",Color.parseColor("#f45722")),
    COFFEE_PERIOD("Coffee Period","Americano",Color.parseColor("#607d8b"));


    public final String title, flavor;
    public final int backgroundColor;

    Cafe(String title, String flavor, int backgroundColor) {
        this.title = title;
        this.flavor = flavor;
        this.backgroundColor = backgroundColor;
    }

}
