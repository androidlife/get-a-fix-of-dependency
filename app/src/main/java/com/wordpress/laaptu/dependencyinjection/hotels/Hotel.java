package com.wordpress.laaptu.dependencyinjection.hotels;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wordpress.laaptu.dependencyinjection.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by laaptu on 6/7/17.
 */

public abstract class Hotel extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    abstract String getHotelTitle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getHotelTitle());
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
                changeHotel();
                break;
            case R.id.menu_change_restaurant:
                changeRestaurant();
                break;
        }
        return true;
    }

    public void changeHotel() {

    }

    public void changeRestaurant() {

    }
}
