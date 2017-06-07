package com.wordpress.laaptu.dependencyinjection.hotels.restaurants;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.utils.Cafe;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 */

public abstract class Restaurant extends Fragment {


    private static final String ARG_TITLE = "title", ARG_BACKGROUND = "bg", ARG_BTN_TEXT = "buttonText";
    @BindView(R.id.btn_brew_coffee)
    Button brewCoffee;
    @BindView(R.id.txt_title)
    TextView title;
    @BindView(R.id.main_layout)
    ViewGroup container;
    @BindView(R.id.txt_info)
    TextView txtInfo;

    private String dateFormat = "'at' hh:mm:ss aaa 'on' d MMM yyyy ',' EEE";
    private SimpleDateFormat simpleDateFormat;
    private String flavor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle params = getArguments();
        if (params == null) {
            throw new RuntimeException("Restaurant can't be opened without title and background");
        }
        title.setText(params.getString(ARG_TITLE, ""));
        flavor =
                params.getString(ARG_BTN_TEXT, "");
        brewCoffee.setText(getString(R.string.brew_coffee, flavor));

        container.setBackgroundColor(
                params.getInt(ARG_BACKGROUND, Color.BLACK)
        );

        simpleDateFormat = new SimpleDateFormat(dateFormat);

    }

    @OnClick(R.id.btn_brew_coffee)
    public void onButtonClick() {
            updateCoffeeBrewingInfo();
    }

    public void updateCoffeeBrewingInfo() {
        String time = simpleDateFormat.format(Calendar.getInstance().getTime());
        String brewInfo = String.format("Brewed coffee with %s flavor", flavor);
        txtInfo.setText(
                brewInfo.concat(" ").concat(time));

    }

    public static Bundle buildParams(Cafe cafe) {
        Bundle params = new Bundle();
        params.putString(ARG_TITLE, cafe.title);
        params.putString(ARG_BTN_TEXT, cafe.flavor);
        params.putInt(ARG_BACKGROUND, cafe.backgroundColor);
        return params;
    }


}
