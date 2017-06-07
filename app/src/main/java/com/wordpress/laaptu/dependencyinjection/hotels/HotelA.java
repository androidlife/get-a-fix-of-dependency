package com.wordpress.laaptu.dependencyinjection.hotels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.dagger.components.CoffeeComponentForHotelA;
import com.wordpress.laaptu.dependencyinjection.dagger.components.WaterComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeHeart;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CafeLove;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;

import javax.inject.Inject;
import javax.inject.Named;

public class HotelA extends Hotel {

    private static final String CAFE_LOVE = "CafeLove", CAFE_HEART = "CafeHeart";
    private String currentCafe = null;

    public CoffeeComponentForHotelA coffeeComponentForHotelA;


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

        WaterComponent waterComponent = ((MainApplication) getApplication()).getWaterComponent();
        coffeeComponentForHotelA = waterComponent.getCoffeeComponentForHotelA(new CoffeeBrewerProvider(Coffee.Flavor.Espresso));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        coffeeComponentForHotelA = null;
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
