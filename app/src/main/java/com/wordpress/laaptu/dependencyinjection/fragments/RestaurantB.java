package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.wordpress.laaptu.dependencyinjection.HotelA;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.dagger.components.CoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;
import timber.log.Timber;

import javax.inject.Inject;

/**
 */

public class RestaurantB extends BaseFragment {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_brew_coffee)
    Button btnBrewCoffee;
    //For coffee
    int waterQuantity =10;
    Coffee.Flavor flavor = Coffee.Flavor.Latte;

    public RestaurantB() {

    }

    public static RestaurantB getInstance(Bundle params) {
        RestaurantB restaurantB = new RestaurantB();
        restaurantB.setArguments(params);
        return restaurantB;
    }

    @Override
    int getLayoutId() {
        return R.layout.restaurant_b;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.d("onActivityCreated()");
        txtTitle.setText("Restaurant B");
        btnBrewCoffee.setText(getString(R.string.brew_coffee, "Latte"));
        goDagger();
    }

    @Inject
    public CoffeeBrewer coffeeBrewer;
    private CoffeeComponent coffeeComponent;
    private void goDagger() {
        if(getContext() instanceof HotelA){
            HotelA hotelA = (HotelA)getContext();
            coffeeComponent = hotelA.getCoffeeComponent(Coffee.Flavor.Latte);
            coffeeComponent.provideCoffeeBrewer(this);
        }
    }

    private void withDagger() {
        coffeeBrewer.brewCoffee();
    }

    @OnClick(R.id.btn_brew_coffee)
    public void brewCoffee() {
        withDagger();
    }


}
