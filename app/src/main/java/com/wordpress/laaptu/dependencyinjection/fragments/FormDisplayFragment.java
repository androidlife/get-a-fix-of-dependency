package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.wordpress.laaptu.dependencyinjection.R;

/**
 */

public class FormDisplayFragment extends Fragment {



  private EditText infoText;

  public FormDisplayFragment() {

  }

  public static FormDisplayFragment getInstance(Bundle params) {
    FormDisplayFragment formDisplayFragment = new FormDisplayFragment();
    formDisplayFragment.setArguments(params);
    return formDisplayFragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.form_display, container, false);
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    
  }
}
