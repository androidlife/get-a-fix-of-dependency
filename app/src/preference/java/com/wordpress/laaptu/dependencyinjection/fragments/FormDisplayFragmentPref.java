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
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import com.wordpress.laaptu.dependencyinjection.data.PrefManager;
import com.wordpress.laaptu.dependencyinjection.model.User;

/**
 */

public class FormDisplayFragmentPref extends BaseFragment {

  private TextView infoText;
  private int titleStyle = R.style.DisplayTitleTextStyle, infoStyle = R.style.DisplayInfoTextStyle;

  public FormDisplayFragmentPref() {

  }

  public static FormDisplayFragmentPref getInstance(Bundle params) {
    FormDisplayFragmentPref formDisplayFragmentPref = new FormDisplayFragmentPref();
    formDisplayFragmentPref.setArguments(params);
    return formDisplayFragmentPref;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.form_display, container, false);
    infoText = (TextView) view.findViewById(R.id.info_txt);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setUserInfo(getUser());
  }

  private void setUserInfo(User user) {
    if (user == null) return;
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    appendValues(spannableStringBuilder, getString(R.string.name), user.name);
    appendValues(spannableStringBuilder, getString(R.string.email), user.email);
    appendValues(spannableStringBuilder, getString(R.string.address), user.address);
    appendValues(spannableStringBuilder, getString(R.string.phone), user.phone);
    infoText.setText(spannableStringBuilder);
  }

  private void appendValues(SpannableStringBuilder ssb, String name, String value) {
    int startIndex = ssb.length();
    ssb.append(name.concat(":\n"));
    ssb.setSpan(new TextAppearanceSpan(getContext(), R.style.DisplayTitleTextStyle), startIndex,
        ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    startIndex = ssb.length();
    ssb.append(value.concat("\n\n"));
    ssb.setSpan(new TextAppearanceSpan(getContext(), R.style.DisplayInfoTextStyle), startIndex,
        ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
  }

  @Override public User getUser() {
    return PrefManager.getInstance(getContext(), PrefManager.PREF_NAME).getUser();
  }
}
