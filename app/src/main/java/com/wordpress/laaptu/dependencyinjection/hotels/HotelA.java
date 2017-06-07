package com.wordpress.laaptu.dependencyinjection.hotels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeHeart;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeLove;

public class HotelA extends Hotel {

    private static final String CAFE_LOVE = "CafeLove", CAFE_HEART = "CafeHeart";
    private String currentCafe = null;

    @Override
    String getHotelTitle() {
        return "Hotel A";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);

        getSupportFragmentManager().beginTransaction().replace(
                R.id.container, CafeLove.getInstance(), CAFE_LOVE).commit();
        currentCafe = CAFE_LOVE;
    }

    @Override
    public void changeHotel() {
        startActivity(new Intent(this, HotelB.class));
    }

    @Override
    public void changeRestaurant() {
        Fragment fragment = null;
        switch (currentCafe) {
            case CAFE_LOVE:
                fragment = CafeHeart.getInstance();
                currentCafe = CAFE_HEART;
                break;
            case CAFE_HEART:
                fragment = CafeLove.getInstance();
                currentCafe = CAFE_LOVE;
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container, fragment, currentCafe
            ).commit();
        }
    }



}
