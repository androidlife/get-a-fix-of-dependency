package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.dagger.CoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.DaggerCoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;

/**
 */

public class RestaurantA extends BaseFragment {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_brew_coffee)
    Button btnBrewCoffee;

    //For coffee
    int waterQuantity = 10;
    Coffee.Flavor flavor = Coffee.Flavor.Espresso;


    public RestaurantA() {

    }

    public static RestaurantA getInstance(Bundle params) {
        RestaurantA restaurantA = new RestaurantA();
        restaurantA.setArguments(params);
        return restaurantA;
    }

    @Override
    int getLayoutId() {
        return R.layout.restaurant_a;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.d("onActivityCreated()");
        txtTitle.setText("Restaurant A");
        btnBrewCoffee.setText(getString(R.string.brew_coffee, "Espresso"));
        goDagger();
    }

    @Inject
    public CoffeeHelper coffeeHelper;
    private CoffeeComponent coffeeComponent;
    private void goDagger() {
        coffeeComponent = DaggerCoffeeComponent.builder().build();
        coffeeComponent.provideCoffee(this);
    }



    private void withDagger() {
        CoffeeBrewer coffeeBrewer = coffeeHelper.getCoffeeBrewer(waterQuantity, flavor);
        coffeeBrewer.brewCoffee();
    }


    @OnClick(R.id.btn_brew_coffee)
    public void brewCoffee() {
        withDagger();
    }


    private void brewWithHelper() {
        CoffeeHelper coffeeHelper = new CoffeeHelper();
        CoffeeBrewer coffeeBrewer = coffeeHelper.getCoffeeBrewer(waterQuantity, flavor);
        coffeeBrewer.brewCoffee();
    }

    private void brewUsual() {
        Water water = new Water(waterQuantity);
        Coffee coffee = new Coffee(flavor);
        CoffeeBrewer coffeeBrewer = new CoffeeBrewer(water, coffee);
        coffeeBrewer.brewCoffee();
    }
}
