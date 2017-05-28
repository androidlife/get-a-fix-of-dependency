package com.wordpress.laaptu.dependencyinjection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wordpress.laaptu.dependencyinjection.dagger.components.CoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.components.DaggerWaterComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.components.WaterComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.CoffeeBrewerProvider;
import com.wordpress.laaptu.dependencyinjection.dagger.providers.WaterProvider;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantA;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;

public class HotelA extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private static final String FRAG_RESTAURANTA = "restaurantA", FRAG_RESTAURANTB = "restaurantB";
    private String currentFragmentTag = null;

    private WaterComponent waterComponent;
    private CoffeeComponent coffeeComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_a);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setTitle("Hotel A");

        getSupportFragmentManager().beginTransaction().replace(
                R.id.container, RestaurantA.getInstance(null), FRAG_RESTAURANTA).commit();
        currentFragmentTag = FRAG_RESTAURANTA;
        initWaterComponent();
    }

    private void initWaterComponent() {
        waterComponent = DaggerWaterComponent.builder().waterProvider(new WaterProvider(20)).build();
    }

    public CoffeeComponent getCoffeeComponent(Coffee.Flavor flavor) {
        coffeeComponent = waterComponent.getCoffeeComponent(new CoffeeBrewerProvider(flavor));
        return coffeeComponent;
    }

    public void removeCoffeeComponent() {
        coffeeComponent = null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_change_hotel:
                startActivity(new Intent(this, HotelB.class));
                break;
            case R.id.menu_change_restaurant:
                toggleFragment();
                break;
        }
        return true;
    }

    private void toggleFragment() {
        Fragment fragment = null;
        switch (currentFragmentTag) {
            case FRAG_RESTAURANTA:
                fragment = RestaurantB.getInstance(null);
                currentFragmentTag = FRAG_RESTAURANTB;
                break;
            case FRAG_RESTAURANTB:
                fragment = RestaurantA.getInstance(null);
                currentFragmentTag = FRAG_RESTAURANTA;
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container, fragment, currentFragmentTag
            ).commit();
        }
    }


}
