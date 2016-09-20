package com.wordpress.laaptu.dependencyinjection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wordpress.laaptu.dependencyinjection.R;

/**
 */

public class FormEditFragment extends Fragment {

  public static FormEditFragment getInstance(Bundle params) {
    FormEditFragment fragment = new FormEditFragment();
    fragment.setArguments(params);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.form_edit, container, false);
  }
}
