package com.wordpress.laaptu.dependencyinjection;

import android.app.Application;
import com.wordpress.laaptu.dependencyinjection.dagger.DaggerDataComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.DataComponent;
import com.wordpress.laaptu.dependencyinjection.dagger.DataModule;

/**
 */

public class MainApplication extends Application {
  private DataComponent dataComponent;

  @Override public void onCreate() {
    super.onCreate();
    dataComponent = DaggerDataComponent.builder().dataModule(new DataModule(this)).build();
  }

  public DataComponent getDataComponent() {
    return dataComponent;
  }
}
