package com.wordpress.laaptu.dependencyinjection.widgets;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

  @Override public void addView(View child, int index, ViewGroup.LayoutParams params) {
    super.addView(child, index, params);
    EditText editText = getEditText();
    if (editText != null) {
      editText.addTextChangedListener(new TextWatcher() {
        @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override public void afterTextChanged(Editable editable) {
          if (!TextUtils.isEmpty(editable.toString()) && getError() != null) {
            setError(null);
            setErrorEnabled(false);
          }
        }
      });
    }
  }
}
