package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.wordpress.laaptu.dependencyinjection.R;

import butterknife.BindView;

/**
 */

public class RestaurantB extends BaseFragment {

    @BindView(R.id.txt_title)
    TextView txtTitle;

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
        txtTitle.setText("Restaurant B");
    }
}
