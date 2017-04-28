package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.wordpress.laaptu.dependencyinjection.R;

import butterknife.BindView;

/**
 */

public class RestaurantA extends BaseFragment {

  @BindView(R.id.txt_title)
  TextView txtTitle;

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
  }
}
