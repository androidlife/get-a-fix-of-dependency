package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Coffee;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.CoffeeBrewer;
import com.wordpress.laaptu.dependencyinjection.menu.coffee.Water;
import com.wordpress.laaptu.dependencyinjection.utils.CoffeeHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 */

public class RestaurantA extends BaseFragment {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_brew_coffee)
    Button btnBrewCoffee;


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
        txtTitle.setText("Restaurant A");
        btnBrewCoffee.setText(getString(R.string.brew_coffee, "Espresso"));

    }

    @OnClick(R.id.btn_brew_coffee)
    public void brewCoffee() {
        brewWithHelper();
    }

    private void brewWithHelper() {
        CoffeeBrewer coffeeBrewer = CoffeeHelper.Instance.getCoffeeBrewer(10, Coffee.Flavor.Espresso);
        coffeeBrewer.brewCoffee();
    }
    private void brewUsual() {
        Water water = new Water(10);
        Coffee coffee = new Coffee(Coffee.Flavor.Espresso);
        CoffeeBrewer coffeeBrewer = new CoffeeBrewer(water, coffee);
        coffeeBrewer.brewCoffee();
    }
}
