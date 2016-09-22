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
import com.wordpress.laaptu.dependencyinjection.R;
import com.wordpress.laaptu.dependencyinjection.data.DbManager;
import com.wordpress.laaptu.dependencyinjection.data.PrefManager;
import com.wordpress.laaptu.dependencyinjection.events.Events;
import com.wordpress.laaptu.dependencyinjection.model.User;
import com.wordpress.laaptu.dependencyinjection.widgets.EditFormTextInputLayout;

/**
 */

public class FormEditFragment extends BaseFragment {

  EditFormTextInputLayout inputName, inputEmail, inputAddress, inputPhone;
  EditText txtName, txtEmail, txtAddress, txtPhone;
  User user;

  public static FormEditFragment getInstance(Bundle params) {
    FormEditFragment fragment = new FormEditFragment();
    fragment.setArguments(params);
    return fragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.form_edit, container, false);
    initViews(view);
    return view;
  }

  private void initViews(View view) {
    inputName = (EditFormTextInputLayout) view.findViewById(R.id.text_input_name);
    inputEmail = (EditFormTextInputLayout) view.findViewById(R.id.text_input_email);
    inputAddress = (EditFormTextInputLayout) view.findViewById(R.id.text_input_address);
    inputPhone = (EditFormTextInputLayout) view.findViewById(R.id.text_input_phone);

    txtName = (EditText) view.findViewById(R.id.txt_name);
    txtEmail = (EditText) view.findViewById(R.id.txt_email);
    txtAddress = (EditText) view.findViewById(R.id.txt_address);
    txtPhone = (EditText) view.findViewById(R.id.txt_phone);
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    user = getUser();
    setValues();
  }

  private void setValues() {
    if (user == null) {
      user = new User();
      return;
    }
    txtName.setText(user.name);
    txtEmail.setText(user.email);
    txtAddress.setText(user.address);
    txtPhone.setText(user.phone);
  }

  @Subscribe public void onSubmit(Events.EventSave event) {
    validateInput();
  }

  private void validateInput() {
    User user = new User();
    user.name = txtName.getText().toString();
    if (TextUtils.isEmpty(user.name)) {
      showError(inputName, R.string.error_name);
      return;
    }
    user.email = txtEmail.getText().toString();
    if (TextUtils.isEmpty(user.email) || !Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
      showError(inputEmail, R.string.error_email);
      return;
    }
    user.address = txtAddress.getText().toString();
    if (TextUtils.isEmpty(user.address)) {
      showError(inputAddress, R.string.error_address);
      return;
    }
    user.phone = txtPhone.getText().toString();
    if (TextUtils.isEmpty(user.phone) || !Patterns.PHONE.matcher(user.phone).matches()) {
      showError(inputPhone, R.string.error_phone);
      return;
    }
    saveNewUserInfo(user);
  }

  private void showError(EditFormTextInputLayout view, int errorStringId) {
    view.setError(getString(errorStringId));
  }

  private void saveNewUserInfo(User user) {
    //PrefManager.getInstance(getContext(),PrefManager.PREF_NAME ).storeUser(user);
    //OR
    DbManager.getInstance(getContext()).storeUser(user);
    postEvent(new Events.EventToggle());
  }

  @Override public User getUser() {
    //return PrefManager.getInstance(this,PrefManager.PREF_NAME).getUser();
    // OR
    return DbManager.getInstance(getContext()).getUser();
  }
}
