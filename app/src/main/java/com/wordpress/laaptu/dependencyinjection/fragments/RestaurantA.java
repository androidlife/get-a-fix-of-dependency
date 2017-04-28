package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.model.User;
import javax.inject.Inject;

/**
 */

public class RestaurantA extends BaseFragment {

  public RestaurantA() {

  }

  public static RestaurantA getInstance(Bundle params) {
    RestaurantA restaurantA = new RestaurantA();
    restaurantA.setArguments(params);
    return restaurantA;
  }

  @Override
  int getLayoutId() {
    return 0;
  }
}
