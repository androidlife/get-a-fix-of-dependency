package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.squareup.otto.Subscribe;
import com.wordpress.laaptu.dependencyinjection.MainApplication;
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.data.DataService;
import com.wordpress.laaptu.dependencyinjection.events.Events;
import com.wordpress.laaptu.dependencyinjection.model.User;
import com.wordpress.laaptu.dependencyinjection.widgets.EditFormTextInputLayout;

import javax.inject.Inject;

/**
 */

public class RestaurantB extends BaseFragment {

    public RestaurantB(){

    }

    public static RestaurantB getInstance(Bundle params) {
        RestaurantB restaurantB = new RestaurantB();
        restaurantB.setArguments(params);
        return restaurantB;
    }

    @Override
    int getLayoutId() {
        return 0;
    }
}
