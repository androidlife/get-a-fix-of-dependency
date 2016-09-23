package com.wordpress.laaptu.dependencyinjection;

import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by laaptu on 9/23/16.
 */

public class CustomMatchers {
  public static Matcher<View> matchesTextWithValue(final String text) {
    return new TypeSafeMatcher<View>() {
      @Override protected boolean matchesSafely(View item) {
        if (item instanceof EditText) {
          return ((AppCompatEditText) item).getText().toString().contains(text);
        }
        return false;
      }

      @Override public void describeTo(Description description) {

      }
    };
  }
}
