package com.wordpress.laaptu.dependencyinjection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantA;
import com.wordpress.laaptu.dependencyinjection.fragments.RestaurantB;

public class HotelA extends AppCompatActivity {

    Toolbar toolbar;

    private static final String RESTAURANT_A = "RestaurantA", RESTAURNAT_B =
            "RestaurantB";

    public enum FragState {
        RestaurantA, RestaurantB
    }

    private FragState fragState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        changeFragment(FragState.RestaurantA);
    }

    private void changeFragment(FragState fragState) {
        if (this.fragState != null && this.fragState == fragState) return;
        this.fragState = fragState;
        switch (fragState) {
            case RestaurantA:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, RestaurantA.getInstance(null), RESTAURANT_A)
                        .commit();
                break;
            case RestaurantB:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, RestaurantB.getInstance(null), RESTAURNAT_B)
                        .commit();
                break;
        }
        invalidateOptionsMenu();
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
                changeRestaurant();
                break;
        }
        return true;
    }


    public void changeRestaurant() {
        if (fragState == null) return;
        FragState newState = (fragState == FragState.RestaurantA) ? FragState.RestaurantB : FragState.RestaurantA;
        changeFragment(newState);
    }


}
