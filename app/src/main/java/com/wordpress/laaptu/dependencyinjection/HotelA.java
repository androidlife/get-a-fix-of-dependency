package com.wordpress.laaptu.dependencyinjection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wordpress.laaptu.dependencyinjection.dagger.CoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.DaggerCoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantA;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import java.lang.ref.WeakReference;

public class HotelA extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private final String RESTAURANT_A = "RestaurantA", RESTAURANT_B = "RestaurantB";

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
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                RestaurantA.getInstance(null), RESTAURANT_A).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void toggleRestaurant() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(RESTAURANT_A);
        if (fragment == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    RestaurantA.getInstance(null), RESTAURANT_A).commit();
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                RestaurantB.getInstance(null), RESTAURANT_B).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_change_hotel:
                startActivity(new Intent(this, HotelB.class));
                break;
            case R.id.menu_change_restaurant:
                toggleRestaurant();
                break;
        }
        return true;
    }

    public CoffeeComponent getCoffeeComponent() {
        if (coffeeComponent == null)
            coffeeComponent = DaggerCoffeeComponent.builder().build();
        return coffeeComponent;
    }

    public void clearComponent() {
        coffeeComponent = null;
    }

    private WeakReference<CoffeeHelper> coffeeHelperWeakReference;

    public void storeWeakReference(CoffeeHelper coffeeHelper) {
        coffeeHelperWeakReference = new WeakReference<>(coffeeHelper);
    }


}
