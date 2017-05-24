package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.dagger.restaurantb.CoffeeComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.restaurantb.DaggerIngredientsComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.restaurantb.IngredientsComponent;
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
    public CoffeeHelper coffeeHelper;
    @Inject
    public Water water;
    private CoffeeComponent coffeeComponent;
    private void goDagger() {
        IngredientsComponent ingredientsComponent =
                DaggerIngredientsComponent.builder().build();
        coffeeComponent = ingredientsComponent.provideCoffeeComponent();
        //coffeeComponent.provideCoffee(this);
    }

    private void withDagger() {
        coffeeComponent.provideCoffee(this);
        CoffeeBrewer coffeeBrewer = coffeeHelper.getCoffeeBrewer();
        coffeeBrewer.brewCoffee();
    }

    @OnClick(R.id.btn_brew_coffee)
    public void brewCoffee() {
        withDagger();
    }


    private void brewWithHelper() {
        CoffeeHelper coffeeHelper  =new CoffeeHelper();
        CoffeeBrewer coffeeBrewer = coffeeHelper.getCoffeeBrewer(waterQuantity,flavor);
        coffeeBrewer.brewCoffee();
    }
    private void brewUsual() {
        Water water = new Water(waterQuantity);
        Coffee coffee = new Coffee(flavor);
        CoffeeBrewer coffeeBrewer = new CoffeeBrewer(water, coffee);
        coffeeBrewer.brewCoffee();
    }
}
