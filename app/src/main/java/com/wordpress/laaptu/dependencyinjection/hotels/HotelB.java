package com.wordpress.laaptu.dependencyinjection.hotels;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.dagger.components.CoffeeComponentForHotelA;
import com.wordpress.laaptu.dependencyinjection.dagger.components.CoffeeComponentForHotelB;
import com.wordpress.laaptu.dependencyinjection.dagger.components.WaterComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CoffeePeriod;
import com.wordpress.laaptu.dependencyinjection.hotels.restaurants.CoffeeTime;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by laaptu on 4/25/17.
 */

public class HotelB extends Hotel {

    private static final String COFFEE_TIME = "CoffeeTime", COFFEE_PERIOD = "CoffeePeriod";
    private String currentCafe = null;

    public CoffeeComponentForHotelB coffeeComponentForHotelB;

    @Override
    String getHotelTitle() {
        return "Hotel B";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.container, CoffeeTime.getInstance(), COFFEE_TIME).commit();
        currentCafe = COFFEE_TIME;

        WaterComponent waterComponent = ((MainApplication) getApplication()).getWaterComponent();
        coffeeComponentForHotelB = waterComponent.getCoffeeComponentForHotelB(
                new CoffeeBrewerProvider(Coffee.Flavor.Americano));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        coffeeComponentForHotelB = null;
    }

    @Override
    public void changeHotel() {
        this.finish();
    }

    @Override
    public void changeRestaurant() {
        Fragment fragment = null;
        switch (currentCafe) {
            case COFFEE_TIME:
                fragment = CoffeePeriod.getInstance();
                currentCafe = COFFEE_PERIOD;
                break;
            case COFFEE_PERIOD:
                fragment = CoffeeTime.getInstance();
                currentCafe = COFFEE_TIME;
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container, fragment, currentCafe
            ).commit();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}
