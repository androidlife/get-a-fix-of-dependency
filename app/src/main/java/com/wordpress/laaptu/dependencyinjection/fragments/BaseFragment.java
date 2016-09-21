package com.wordpress.laaptu.dependencyinjection.fragments;

import android.support.v4.app.Fragment;
import com.wordpress.laaptu.dependencyinjection.events.BusProvider;
import com.wordpress.laaptu.dependencyinjection.model.User;

/**
 */

public abstract class BaseFragment extends Fragment {

  public abstract User getUser();
  @Override public void onResume() {
    super.onResume();
    BusProvider.getEventBus().register(this);
  }

  @Override public void onPause() {
    super.onPause();
    BusProvider.getEventBus().unregister(this);
  }

  public void postEvent(Object event) {
    BusProvider.getEventBus().postEvent(event);
  }
}
