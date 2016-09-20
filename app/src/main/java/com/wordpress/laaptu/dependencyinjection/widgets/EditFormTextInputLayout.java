package com.wordpress.laaptu.dependencyinjection.widgets;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import com.wordpress.laaptu.dependencyinjection.R;

/**
 */

public class EditFormTextInputLayout extends TextInputLayout {
  public EditFormTextInputLayout(Context context) {
    this(context, null);
  }

  public EditFormTextInputLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public EditFormTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, R.attr.textInputLayoutStyle);
  }
}
